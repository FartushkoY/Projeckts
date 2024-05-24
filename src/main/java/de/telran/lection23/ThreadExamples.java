package de.telran.lection23;

public class ThreadExamples {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());
        System.out.println(mainThread);


        // thread with Runnable
        Runnable runnable = new RunnableTask();
        Thread additionalThread = new Thread(runnable, "MyThread1");
        Thread additionalThread2 = new Thread(runnable, "MyThread2");
        System.out.println("Threads created");
        additionalThread.start();
        additionalThread2.start();

        System.out.println("Main logic");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            additionalThread.join();
            additionalThread2.join();
            System.out.println("Logic after end of MyThread1, MyThread2");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // thread with new Thread instance
        ThreadTask customThread = new ThreadTask();
//        customThread.run(); // works in main thread
        customThread.start(); // works in separate thread
        System.out.println(customThread.counter);

        try {
            customThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(customThread.counter);

        System.out.println("Main end");
    }

    static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Start of actions in additional thread: " + Thread.currentThread().getName());
            // some code
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End of actions in additional thread: " + Thread.currentThread().getName());
        }
    }

    static class ThreadTask extends Thread {
        int counter = 0;

        @Override
        public void run() {
            System.out.println("Run from ThreadTask called in " + Thread.currentThread().getName());
            for (int i = 0; i < 1_000_000_000; i++) {
                counter++;
            }
        }

    }
}
