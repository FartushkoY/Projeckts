package de.telran.lection24_Threads_Synchronized;

public class AwakeningThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                for (int j = 0; j < 100_000_000; j++) {
                    i++;
                }
                System.out.println(i);
                try {
                    System.out.println(Thread.currentThread().getName() + " is sleeping...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is interrupted");;
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.interrupt();
    }
}
