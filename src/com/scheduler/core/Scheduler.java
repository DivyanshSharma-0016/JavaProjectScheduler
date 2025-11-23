package com.scheduler.core;
import com.scheduler.model.Job;

public class Scheduler {
    private final TaskQueue queue;
    private final Worker[] workers;

    public Scheduler(int numWorkers, TaskQueue q) {
        this.queue = q;
        this.workers = new Worker[numWorkers];
        
        // Start the fixed pool of worker threads
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new Worker("Worker-Thread-" + (i + 1), queue);
            workers[i].start(); // Starts the run() method in the Worker class
        }
        System.out.println("Scheduler initialized with " + numWorkers + " worker threads.");
    }
    
    // Method to stop all worker threads gracefully
    public void shutdown() {
        for (Worker worker : workers) {
            worker.interrupt(); // Sends an interrupt signal
        }
        // Wake up any workers still waiting so they can check their interrupt status
        queue.submit(new Job("SHUTDOWN_TRIGGER") {
            @Override
            public void runJob() { /* Do nothing */ }
        });
        System.out.println("Scheduler shutting down.");
    }
}
