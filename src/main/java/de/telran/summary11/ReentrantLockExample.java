package de.telran.summary11;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static ReentrantLock lock = new ReentrantLock(true);
    Object mutex = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");

        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();

        lock.lock();
        try {
            Thread.sleep(5000);
            lock.unlock();
            System.out.println(1 / 0);
        } finally {
            lock.unlock();
        }


        System.out.println("Main end");
    }

    static class Task implements Runnable {


        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " doing task...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(1/0);

                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

