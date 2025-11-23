package com.scheduler.model;

public class DataProcessingJob extends Job { // INHERITS from Job
    
    public DataProcessingJob(String id) {
        super(id); // Calls the constructor of the parent Job class
    }
    
    @Override 
    public void runJob() { // Implementation of the abstract method
        System.out.println(Thread.currentThread().getName() + " is running DataProcessing Job " + getJobId() + ": Crunching data...");
        try {
            Thread.sleep(1500); // Pauses for 1.5 seconds to simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " finished DataProcessing Job " + getJobId() + ".");
    }
}