### Concurrency vs. Parallelism

- **Parallelism:** Multiple tasks are executed *at the same time* on multiple CPUs.
- **Concurrency:** Multiple tasks are alternately executed on *a single CPU*.

### Difference Between Processes and Threads

1. **Resource Usage:**
   - **Process:** A process is an independent unit that includes its own memory, data, and system resources. Each process has its own space and does not interfere with others.
   - **Thread:** A thread is the smallest unit of CPU scheduling within a process. Multiple threads in the same process share memory and resources.

2. **Data Exchange:**
   - **Processes** communicate via inter-process communication (IPC) because they have separate memory.
   - **Threads** in the same process share memory, making data exchange faster and simpler.

3. **Overhead:**
   - **Processes** require more system resources and time to create or destroy because each has its own memory and state.
   - **Threads** are lightweight and easier to manage since they share resources of the process they belong to.

4. **Concurrency:**
   - **Processes** are more stable when handling multiple tasks at once.
   - **Threads** are more complex when it comes to synchronizing and handling concurrent tasks.

In general, using multiple threads for tasks within a process is often more efficient, but requires careful management of concurrent operations. 

### Context Switching

Context switching happens when the CPU switches from one task (process or thread) to another. This involves:

1. **Saving the state** of the current task (e.g., the contents of CPU registers and the program counter).
2. **Loading the state** of the next task.
3. **Resuming execution** of the next task where it left off.

This switching allows multiple tasks to run seemingly at the same time. However, it consumes CPU time, so too many threads or processes can reduce performance due to frequent context switches.

### Summary

- **Processes** enable OS-level concurrency and are independent units with their own resources.
- **Threads** allow concurrency within a process and are lighter, sharing memory and resources.
- **Context switching** is essential for multitasking, but it’s costly in terms of CPU usage. Fewer switches lead to better performance.