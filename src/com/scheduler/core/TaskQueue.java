package com.scheduler.core;
import com.scheduler.model.Job;
import java.util.LinkedList;
import java.util.List;

public class TaskQueue {
    // The list where jobs are held
    private final List<Job> queue = new LinkedList<>();

    // synchronized: Ensures only one Worker thread can access this at a time.
    public synchronized Job getNextJob() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("--- TaskQueue is empty. " + Thread.currentThread().getName() + " waiting... ---");
            // wait(): Makes the Worker thread sleep, releasing the lock.
            // It only wakes up when notifyAll() is called. This is efficient concurrency.
            wait(); 
        }
        return queue.remove(0); // Safely retrieve the job
    }

    // synchronized: Ensures only one thread (the Main thread) can add a job at a time.
    public synchronized void submit(Job job) {
        queue.add(job);
        System.out.println("Scheduler submitted job: " + job.getJobId());
        // notifyAll(): Wakes up all sleeping Worker threads to signal a new job is ready.
        notifyAll(); 
    }
}