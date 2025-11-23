Problem statement:
To design and implement a thread-safe, console-based job scheduler that accepts various types of tasks and concurrently dispatches them to a fixed pool of worker threads, rigorously applying Object-Oriented Programming (OOP), Multithreading, and Synchronization principles.

Scope of the project:
The project focuses entirely on concurrent execution, thread safety (using the synchronized keyword and wait/notify), and robust error handling via custom exceptions (TaskProcessingException). It excludes advanced modules (I/O, JDBC/database connectivity).

Target users:
System developers or administrators needing to schedule basic background processing tasks in a concurrent environment.

High-level features:
1. Task inheritance and Polymorphism (Job class hierarchy).
2. Thread pool management (fixed number of Worker threads).
3. Synchronized task queue for thread-safe submission and retrieval.
4. Custom exception handling for simulated job failures.