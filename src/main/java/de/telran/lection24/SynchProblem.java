package de.telran.lection24;

public class SynchProblem {

    static Object feed = new Object();
    static Object drink = new Object();

    public static void main(String[] args) {
        new Thread(new FeedCatTask()).start();
        new Thread(new FeedCatTask()).start();
        new Thread(new FeedDogTask()).start();


    }

    static class FeedCatTask implements Runnable {

        @Override
        public void run() {
            synchronized (feed) {
                System.out.println(Thread.currentThread().getName() + " feeds cat");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (drink) {
                    System.out.println(Thread.currentThread().getName() + " give cat milk");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

        static class FeedDogTask implements Runnable {

            @Override
            public void run() {
                synchronized (drink) {
                    System.out.println(Thread.currentThread().getName() + " give dog milk");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (feed) {
                        System.out.println(Thread.currentThread().getName() + " give dog milkfeeds dog");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
    }
}
