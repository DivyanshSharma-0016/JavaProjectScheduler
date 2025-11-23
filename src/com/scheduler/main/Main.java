package com.scheduler.main;
import com.scheduler.core.Scheduler;
import com.scheduler.core.TaskQueue;
import com.scheduler.model.DataProcessingJob;
import com.scheduler.model.LoggingJob;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Initialize the system
        TaskQueue queue = new TaskQueue();
        // Start the scheduler with 3 concurrent workers (Multithreading in action)
        Scheduler scheduler = new Scheduler(3, queue); 

        // 2. Submit various jobs (demonstrating Polymorphism)
        System.out.println("\n--- Submitting 10 Jobs to the Queue ---");
        for (int i = 1; i <= 10; i++) {
            String jobId = "Job-" + i;
            if (i % 2 == 0) {
                // Submitting DataProcessingJob
                queue.submit(new DataProcessingJob(jobId)); 
            } else {
                // Submitting LoggingJob
                queue.submit(new LoggingJob(jobId));
            }
            Thread.sleep(50); // Small pause
        }

        // 3. Pause the main thread to allow workers to process the jobs
        System.out.println("\n--- Waiting for 5 seconds to process tasks concurrently... ---");
        Thread.sleep(5000); 

        // 4. Shutdown gracefully (Flow Control)
        scheduler.shutdown();
    }
}