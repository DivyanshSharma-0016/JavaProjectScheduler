package com.scheduler.exceptions;

public class TaskProcessingException extends Exception {
    
    // This custom exception lets us report errors specific to job processing.
    public TaskProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}