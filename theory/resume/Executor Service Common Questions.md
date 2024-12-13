
**1. What is `ExecutorService`, and how does it differ from creating threads manually?**

- **Answer**:
    - `ExecutorService` is a framework for managing and controlling thread execution in Java, part of the `java.util.concurrent` package.
    - Unlike creating threads manually using `new Thread()`, `ExecutorService` provides:
        - Thread pooling for reusability, reducing thread creation overhead.
        - Task submission and result tracking via `Future`.
        - Built-in methods to schedule, cancel, or monitor tasks.
    - It abstracts low-level thread management, making the code more scalable and easier to maintain.

---

**2. Explain `submit()` vs. `execute()` methods.**

- **Answer**:
    - **`execute(Runnable task)`**:
        - Executes the given task asynchronously.
        - Does not return any result or allow task tracking.
        - Typically used for fire-and-forget tasks.
    - **`submit(Callable<T> task)`** or **`submit(Runnable task)`**:
        - Executes the task asynchronously.
        - Returns a `Future` object to track the task status or retrieve the result.
        - Preferred when you need task output or exception handling.

---

**3. How would you handle task cancellation with `ExecutorService`?**

- **Answer**:
    - Use the `Future` object returned by `submit()` to cancel the task.
    - Example:
        
        java
        
        Copy code
        
        `Future<?> future = executorService.submit(() -> {     // Long-running task }); future.cancel(true); // Attempts to stop the task`
        
    - The `cancel()` method has two modes:
        - `true`: Attempts to interrupt the task if it is running.
        - `false`: Allows already-running tasks to complete but prevents new ones from starting.
    - Ensure the task checks for interruptions periodically (e.g., via `Thread.interrupted()`).

---

**4. What happens if you don't call `shutdown()` on an `ExecutorService`?**

- **Answer**:
    - If `shutdown()` is not called:
        - The JVM will keep running indefinitely because the threads in the pool are non-daemon threads.
        - Resources like memory and CPU will not be released.
    - Always call `shutdown()` or `shutdownNow()` to release resources and terminate the threads gracefully.

---

**5. How does thread pooling improve performance?**

- **Answer**:
    - **Thread Reuse**:  
        Threads are reused, avoiding the overhead of creating and destroying threads repeatedly.
    - **Controlled Concurrency**:  
        Limits the number of threads to prevent resource exhaustion.
    - **Efficient Task Execution**:  
        Tasks are executed asynchronously, improving responsiveness and system throughput.
    - **Scalability**:  
        Thread pools adapt to the workload, efficiently handling concurrent tasks.