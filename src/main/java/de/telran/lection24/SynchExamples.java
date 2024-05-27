package de.telran.lection24;

public class SynchExamples {

    static Object mutex = new Object();
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            synchronized (mutex) {
                System.out.println(Thread.currentThread().getName() + " actuoions in synch block");
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " actuoions after synch block");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            System.out.println(Thread.currentThread().getName() + " actuoions in synch block");
            synchronized (mutex) {
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " actuoions after synch block");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });

        thread1.start();
        thread2.start();


    }

}
