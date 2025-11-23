package com.scheduler.model;

public class LoggingJob extends Job { // INHERITS from Job
    
    public LoggingJob(String id) {
        super(id); // Calls the constructor of the parent Job class
    }
    
    @Override 
    public void runJob() { // Implementation of the abstract method
        System.out.println(Thread.currentThread().getName() + " is running Logging Job " + getJobId() + ": Writing application logs...");
        try {
            Thread.sleep(500); // Shorter pause (0.5 seconds) to simulate quick work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " finished Logging Job " + getJobId() + ".");
    }
}
