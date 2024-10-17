import java.util.concurrent.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class SumRangeCallable implements Callable<Integer> {

    private final int start;
    private final int end;

    public SumRangeCallable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        // Get current date and time for start
        LocalDateTime startTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(Thread.currentThread().getName() + " started summing range: " + start + " to " + end +
                ". Start Time: " + startTime.format(formatter));

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        // Get current date and time for end
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(Thread.currentThread().getName() + " finished summing range: " + start + " to " + end +
                ". End Time: " + endTime.format(formatter) + ". Time taken: " +
                (java.time.Duration.between(startTime, endTime).toMillis()) + " ms");

        return sum;
    }
}

class MultipleThreadCreationWithCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Create tasks for summing different ranges of numbers
        FutureTask<Integer> task1 = new FutureTask<>(new SumRangeCallable(1, 100));
        FutureTask<Integer> task2 = new FutureTask<>(new SumRangeCallable(101, 200));
        FutureTask<Integer> task3 = new FutureTask<>(new SumRangeCallable(201, 300));

        long totalStartTime = System.currentTimeMillis();
        
        // Submit tasks to the thread pool and log the start of each thread
        System.out.println("Starting threads...");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        // Wait for and log the results
        Integer result1 = task1.get();
        Integer result2 = task2.get();
        Integer result3 = task3.get();

        // Combine the results
        int finalResult = result1 + result2 + result3;
        System.out.println("Total sum from 1 to 300 = " + finalResult);

        // Log completion and shutdown the executor service
        System.out.println("All tasks are complete. Shutting down...");
        executorService.shutdown();

        // Log the total time taken for the entire process
        long totalEndTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (totalEndTime - totalStartTime) + " ms");
    }
}