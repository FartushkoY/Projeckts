package de.telran.lection27;

import java.util.concurrent.CountDownLatch;

public class RunnersWithCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runner(), "Runner 1");
        Thread thread2 = new Thread(new Runner(), "Runner 2");
        Thread thread3 = new Thread(new Runner(), "Runner 3");
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(5000);
//        thread1.interrupt();
//        Thread.sleep(1000);


        Thread.sleep(1000);

        System.out.println("Ready!");
        latch.countDown();
        Thread.sleep(1000);
        System.out.println("Steady!");
        latch.countDown();
        Thread.sleep(1000);
        System.out.println("Go!");
        latch.countDown();


    }

    static class Runner implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is ready to run.  Waiting for the command");
            try {
                latch.await();
            } catch (InterruptedException ignore) {
            }

            while (true) {
                System.out.println(Thread.currentThread().getName() + " running ...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

