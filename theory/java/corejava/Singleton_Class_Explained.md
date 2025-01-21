# Singleton Design Pattern in Java
> Created using [Shreyansh Video + ChatGPT](https://www.youtube.com/watch?v=SqDbZOjW1uM&list=PL6W8uoQQ2c63f469AyV78np0rbxRFppkx&index=16)

The **Singleton** design pattern ensures that a class has only one instance and provides a global access point to it. It is commonly used to manage shared resources, such as configuration objects or connection pools.

---

## Different Ways to Implement Singleton in Java

### 1. Eager Initialization
The Singleton instance is created when the class is loaded.

```java
public class DBConnection {
    private static final DBConnection INSTANCE = new DBConnection();

    private DBConnection() {
        // Private constructor to prevent instantiation
    }

    public static DBConnection getInstance() {
        return INSTANCE;
    }
}
```

**Tradeoffs:**
- **Pros:** Simple to implement; thread-safe without additional synchronization.
- **Cons:** Instance is created even if it’s never used, which can waste resources.

---

### 2. Lazy Initialization
The Singleton instance is created only when it’s needed.

```java
public class DBConnection {
    private static DBConnection instance;

    private DBConnection() {
        // Private constructor
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}
```



**Tradeoffs:**
- **Pros:** Instance is created only when needed, saving resources.
- **Cons:** Not thread-safe in a multithreaded environment.
> Example : Say there are threads T1 & T2 which comes for Lazy Initialisation. So for both T1 and T2, the instance will be null and hence two instances gets created. This violates the singleton design pattern.
---

### 3. Thread-Safe Singleton with Synchronization
Using synchronization to make `DBConnection` thread-safe.

```java
public class DBConnection {
    private static DBConnection instance;

    private DBConnection() {
        // Private constructor
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}
```
> Example : In case of two threads T1 & T2 coming for the first time, with lazy initialization, two objects were created. With the use of 'synchronized' keyword, this can be prevented as everytime a thread comes up it locks the method till its execution.  

**Tradeoffs:**
- **Pros:** Thread-safe.
- **Cons:** Synchronization can cause performance overhead in high-concurrency scenarios.
> Example : Let's say this getInstance() method for current case, is called in 100 places. Then for each thread, for 100 times locking and unlocking of the method will happen for object initialisation which will slow the system down.

---

### 4. Double-Checked Locking
Improves performance by reducing the overhead of synchronization.

```java
public class DBConnection {
    private static volatile DBConnection instance;

    private DBConnection() {
        // Private constructor
    }

    public static DBConnection getInstance() {
        if (instance == null) { // 1stCheck
            synchronized (DBConnection.class) {
                if (instance == null) { // 2ndCheck
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }
}
```

**Tradeoffs:**
- **Pros:** Efficient, avoids unnecessary synchronization after the instance is initialized.
- **Cons:** Uses `volatile` keyword which means it is not using cache for efficient lookups and rather uses main memory. So still SLOWER which is where Bill Pugh Singleton method comes in.

[explained better here in Shreyansh Video](https://www.youtube.com/watch?v=SqDbZOjW1uM&t=517s)

1) Example : Solves problem of Concurrency faced in LAZY Initialisation
``` 
Let's take the previous e.g., where threads T1 and T2 come at the same time. 
1) 1st Check : For thread T1, instance is NULL, LOCK is created by synchronised and the INSTANCE is created. 
2) 2nd Check : LOCK is created by synchronised and the INSTANCE is still null. Hence INSTANCE created.
Now when T2 comes, it sees that INSTANCE is already created, so that same INSTANCE is returned

```
2) Why is **VOLATILE** keyword important ??
Concurrency Issues Solved by volatile
* **Visibility Issue** : In a multi-threaded program, changes made to a variable by one thread may not be immediately visible to other threads. This happens because threads can cache variables locally, and updates may not be written back to the main memory immediately. The volatile keyword ensures visibility by enforcing that all threads read the variable's latest value directly from main memory.


* **Reordering Issue** : Without volatile, the Java compiler, runtime, or CPU may reorder instructions for optimization purposes, potentially leading to inconsistent or unexpected behavior in a multi-threaded context. The volatile keyword prevents such reordering for the variable it is applied to.
---

### 5. Bill Pugh Singleton (Static Inner Class)
1. Nested classes get loaded only when they're invoked & not at the start of application.
2. JVM's thread safety guarantee.

```java
public class DBConnection {
    private DBConnection() {
        // Private constructor
    }

    private static class SingletonHelper { 
        private static final DBConnection INSTANCE = new DBConnection();
    }

    public static DBConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
```

**Tradeoffs:**
- **Pros:** Simple, lazy initialization, and thread-safe without synchronization.
- **Cons:** None in most cases; widely regarded as the best approach.

---

### 6. Enum Singleton
> Enum in java makes sure that only one INSTANCE exists per JVM. 
> No need to create a private constructor as that is taken care by default. 
> Enum-based Singleton is thread-safe and serialization-safe by design.

```java
public enum DBConnection {
    INSTANCE;

    public void someMethod() {
        // Define Singleton behavior here
    }
}
```

**Tradeoffs:**
- **Pros:** Thread-safe, handles serialization and reflection automatically.
- **Cons:** Cannot be lazily initialized; may be overkill for simple use cases.

---

## Comparison and Tradeoffs

| Approach                      | Lazy Initialization | Thread-Safe | Serialization-Safe | Complexity | Usage Scenario                                   |
|-------------------------------|---------------------|-------------|--------------------|------------|------------------------------------------------|
| Eager Initialization          | No                  | Yes         | No                 | Low        | Use when Singleton is always needed.           |
| Lazy Initialization           | Yes                 | No          | No                 | Low        | Simple use cases in a single-threaded app.     |
| Thread-Safe Singleton         | Yes                 | Yes         | No                 | Medium     | Use when simplicity is preferred over speed.   |
| Double-Checked Locking        | Yes                 | Yes         | No                 | High       | Best for high-performance multithreaded apps.  |
| Bill Pugh Singleton           | Yes                 | Yes         | No                 | Low        | Recommended; combines simplicity and safety.   |
| Enum Singleton                | No                  | Yes         | Yes                | Low        | Best for serialization-safe scenarios.         |

---

## Choosing the Right Implementation

- **High-performance apps:** Use **Double-Checked Locking** or **Bill Pugh Singleton**.
- **Serialization required:** Use **Enum Singleton**.
- **Simple requirements:** Use **Eager Initialization** or **Lazy Initialization** depending on the use case.

---

