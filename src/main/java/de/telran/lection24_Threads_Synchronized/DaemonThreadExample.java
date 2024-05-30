package de.telran.lection24_Threads_Synchronized;

import java.time.ZonedDateTime;

public class DaemonThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " : " + i++ + " : " + ZonedDateTime.now());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.setDaemon(true);
        thread.setPriority(5);
        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
