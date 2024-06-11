package de.telran.summary12;

import java.util.concurrent.*;

public class ThreadPools {

    static class RunnableTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished the task");
        }
    }

    static class CallableTask implements Callable<String> {
        @Override
        public String call() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished the task");
            return "string from task";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RunnableTask task1 = new RunnableTask();
        RunnableTask task2 = new RunnableTask();
        CallableTask task3 = new CallableTask();
        CallableTask task4 = new CallableTask();
        CallableTask task5 = new CallableTask();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);


        ExecutorService executor = Executors.newCachedThreadPool();

        Thread.sleep(10_000);

        executor.execute(task1);
        executor.execute(task2);
        Future<String> future3 = executor.submit(task3);
        Future<String> future4 = executor.submit(task4);
        Future<String> future5 = executor.submit(task5);

        String result3 = future3.get();
        String result4 = future4.get();
        String result5 = future5.get();
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

        executor.shutdown();


    }
}
