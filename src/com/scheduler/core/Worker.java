package com.scheduler.core;
import com.scheduler.model.Job;
import com.scheduler.exceptions.TaskProcessingException;

// Extends Thread so each instance runs concurrently
public class Worker extends Thread {
    private final TaskQueue queue;

    public Worker(String name, TaskQueue q) {
        super(name); // Set the thread name (e.g., Worker-Thread-1)
        this.queue = q;
    }

    @Override
    public void run() {
        // The worker keeps running until the Scheduler explicitly stops it
        while (!isInterrupted()) { 
            try {
                // Waits here until a job is submitted to the queue
                Job job = queue.getNextJob(); 
                
                // CRITICAL: Custom Exception Handling
                // We simulate a failure if the Job ID ends with "7"
                if (job.getJobId().endsWith("7")) { 
                    throw new TaskProcessingException("Simulated failure during execution.", null);
                }
                
                job.runJob(); // Executes the job (Polymorphism)
                
            } catch (InterruptedException e) {
                // This is how the Scheduler tells the Worker to stop
                Thread.currentThread().interrupt(); 
                System.out.println(getName() + " has been interrupted and stopped.");
            } catch (TaskProcessingException e) {
                // CATCHING the custom exception we defined
                System.err.println(getName() + " failed to process job: " + e.getMessage());
            } catch (Exception e) {
                // Catching any unexpected errors
                System.err.println(getName() + " encountered unhandled error: " + e.getMessage());
            }
        }
    }
}
