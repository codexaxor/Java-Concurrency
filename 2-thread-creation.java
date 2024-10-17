class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Runnable");
    }
}

class RunnableDemo {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        

        //Using Fucntional Interface
        new Thread(()->{
            System.out.println("Fucntional Interface running from Runnable Interface");
        })
        .start();
    }
}