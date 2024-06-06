package de.telran.lection26;

public class BusyWait {
    private static boolean shouldWait = true;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // command
            shouldWait = false;
            System.out.println(Thread.currentThread().getName() + " doing its tasks...");
            System.out.println(Thread.currentThread().getName() + " ended");

        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            while (shouldWait) {
                // wait
            }
            // wait ----> do
            System.out.println(Thread.currentThread().getName() + " doing its tasks...");
            System.out.println(Thread.currentThread().getName() + " ended");
        }).start();


    }

}
