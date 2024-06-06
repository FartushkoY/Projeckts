package de.telran.lection26;

import java.util.Random;

public class Runners {
    static Object mutex = new Object();

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

        synchronized (mutex) {
            Thread.sleep(1000);
            mutex.notifyAll();
            System.out.println("Ready!");
            Thread.sleep(1000);
            System.out.println("Steady!");
            Thread.sleep(1000);
            System.out.println("Go!");
        }

    }
    static class Runner implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is ready to run");
            synchronized (mutex) {
//                while (!Thread.interrupted()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting for the command");
                    mutex.wait();
                    System.out.println(Thread.currentThread().getName() + " is awaken");
//                        break;
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
//                    e.printStackTrace();
                }
//                }
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
