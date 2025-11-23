package com.scheduler.model;

public abstract class Job {
    private final String jobId; // A unique identifier for the job

    public Job(String id) {
        this.jobId = id; // Initialize the ID when the job is created
    }
    
    // Abstract method: MUST be implemented by any class that inherits from Job
    public abstract void runJob(); 

    // Getter method: Allows outside classes to read the ID
    public String getJobId() {
        return jobId;
    }
}
