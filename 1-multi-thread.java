class SayHelloThread extends Thread {
    public void run() {
        System.out.println("Hello world");
    }
}
class SayLoveThread extends Thread {
    public void run() {
        System.out.println("I love you");
    }
}

class MultiThreadJavaApp {
    public static void main(String[] args) throws InterruptedException {
        SayHelloThread sayHelloThread = new SayHelloThread();
        SayLoveThread sayLoveThread = new SayLoveThread();
        sayHelloThread.start();
        sayLoveThread.start();
        //main thread sleep
        Thread.sleep(5000);
    }
}