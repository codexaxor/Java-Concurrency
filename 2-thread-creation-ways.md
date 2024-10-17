### Callable, Future, and FutureTask: Simple Overview

When creating threads in Java, we typically use `Runnable` or `Thread`. However, they have a limitation: the `run()` method does not return a value. If you need a thread that returns a result, Java provides the **Callable** interface to handle this.

#### Future and FutureTask
To get the result of a `Callable`, you use the **Future** interface. The class **FutureTask** implements both `Runnable` and `Future`, so it can be used for asynchronous tasks with a return value and be passed to a thread for execution.

#### Ways to Create Threads
Threads in Java can be created in different ways:
1. **Runnable Interface**: Use when the thread doesn’t need to return a value.
2. **Callable Interface**: Use when the thread needs to return a result.
3. **Thread Class**: Can be used directly, but it's less flexible.

Although these methods vary, they all create and run threads using `new Thread()`. Another way to create threads is by using thread pools, which will be explained separately.

### Runnable vs Thread: Which is Better?

If you just need a thread without a return value, you can either:
- **Inherit from Thread** or
- **Implement Runnable**.

#### Pros of Using Thread Class:
- Simple: Inheriting from `Thread` is straightforward.
- Control: You can directly manage the thread using methods like `start()`, `pause()`, etc.

#### Cons of Using Thread Class:
- Single Inheritance Limitation: Since Java does not support multiple inheritance, using `Thread` limits the ability to extend other classes.
- Code Coupling: The logic of thread execution is tightly bound to the class, reducing reusability.

#### Pros of Using Runnable Interface:
- **Better Reusability**: The logic for running the thread is separated, allowing for better code reuse.
- **No Inheritance Limitation**: Since it’s an interface, you can implement multiple interfaces without being bound by single inheritance.
- **Extensibility**: It makes it easy to extend functionality without affecting the existing code.

#### Cons of Using Runnable:
- Slightly more complex: You need to create a class that implements `Runnable` and then use `Thread` to run it.
- No direct thread control: You can’t control the thread directly like you can with the `Thread` class methods.

Overall, **using the Runnable interface** is recommended for better code flexibility and maintainability.

### Thread's start() Method

When you call `start()` on a thread, the JVM creates the thread, and the thread begins running when it gets CPU time. The thread's `run()` method is then called to execute its task.

**Important**: You can’t call `start()` multiple times on the same thread. Doing so will throw an `IllegalThreadStateException`.

In summary, the **start()** method initiates the thread and internally calls the native `start0()` method to handle the actual low-level execution.