# Java Concurrent Task Dispatcher (Job Scheduler)

## Overview of the Project
This console application simulates a core operating system component: a concurrent job scheduler. It is designed to accept different types of tasks (jobs) and efficiently dispatch them to a fixed pool of worker threads. The primary goal is to demonstrate robust **Multithreading** and **Object-Oriented Programming (OOP)** principles from Modules 1, 2, and 3.

## Features
This project meets the requirement for **three major functional modules**:

1.  **Task Modeling Module (OOP):** Defines an abstract class (`Job.java`) and concrete inherited classes (`DataProcessingJob`, `LoggingJob`), demonstrating **Inheritance** and **Polymorphism**.
2.  **Concurrency & Synchronization Module:** Uses a thread-safe queue (`TaskQueue.java`) protected by the **`synchronized`** keyword and **`wait()`/`notifyAll()`** for efficient communication between threads.
3.  **Scheduling & Execution Module:** Manages the life cycle of the fixed pool of **Worker Threads** and applies flow control logic in the `Main` loop.

## Technologies/Tools Used
* **Core Language:** Java JDK
* **Key Concepts:** Multithreading, Thread Synchronization, Object-Oriented Programming (OOP), Custom Exception Handling, Command Line Interface (CLI).

## Steps to Install & Run the Project
The project is designed to run directly from the command line on any system with Java JDK installed.

1.  **Project Location:** Ensure the entire project folder (`JavaProject`) is easily accessible (e.g., on your C: drive).
2.  **Open Command Prompt/Terminal:** Navigate to the project root directory:
    ```bash
    cd \JavaProject
    ```

3.  **Compile all files:** (This fixes package errors by compiling all files at once)
    ```bash
    javac src/com/scheduler/main/*.java src/com/scheduler/core/*.java src/com/scheduler/model/*.java src/com/scheduler/exceptions/*.java
    ```

4.  **Run the program:**
    ```bash
    java -cp src com.scheduler.main.Main
    ```

## Instructions for Testing
The project includes automated logic to test key functional and non-functional requirements.

1.  **Concurrent Execution Test:** When the program runs, observe that multiple lines beginning with `Worker-Thread-1`, `Worker-Thread-2`, and `Worker-Thread-3` print to the console simultaneously. This proves the system is running **concurrently**.
2.  **Synchronization Test:** Observe the line `--- TaskQueue is empty. Worker-Thread-X waiting... ---` after all jobs are submitted. This proves the **`wait()`** mechanism is engaged, ensuring threads release CPU time when idle.
3.  **Exception Handling Test:** The job with ID **"Job-7"** is hardcoded to fail. Observe the output line: `Worker-Thread-X failed to process job: Simulated failure during execution.`. This confirms the custom **`TaskProcessingException`** is caught and handled gracefully without crashing the application.

## Screenshots
*(Note: The actual console output screenshot is included in the Project Report PDF for evaluation.)*

