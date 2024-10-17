import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {

    /**
     * Calculate the sum from 1 to 4
     * @return
     */
    @Override
    public Integer call() {
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += i;
        }
        return res;
    }
}

class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.Generate an instance of MyCallable
        MyCallable myCallable = new MyCallable();
        // 2.Create a FutureTask object through myCallable
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        // 3.Create a Thread object through FutureTask
        Thread t = new Thread(futureTask);
        // 4.start the thread
        t.start();
        // 5.Get calculation result
        Integer res = futureTask.get();
        System.out.println(res);
    }
}