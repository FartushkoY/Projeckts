package de.telran.lection25;

import java.sql.Time;
import java.util.Random;

public class TaskRunners {
    static class Runner implements Runnable {

        private long time;

        @Override
        public String toString() {
            return "Runner{" +
                    "time=" + time +
                    '}';
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            Random random = new Random();
            System.out.println("Start" + Thread.currentThread().getName());
            int run = random.nextInt(5000) + 10000;
            try {
                Thread.sleep(run);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End" + Thread.currentThread().getName());
            long end = System.currentTimeMillis();
            setTime(end - start);
        }
    }


    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        Runner runner3 = new Runner();

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(runner1.getTime());
        System.out.println(runner2.getTime());
        System.out.println(runner3.getTime());


        if (runner1.getTime() < runner2.getTime() && runner1.getTime() < runner3.getTime()) {
            System.out.println("vinner: " + runner1);
        } else if (runner2.getTime() < runner1.getTime() && runner2.getTime() < runner3.getTime()) {
            System.out.println("vinner: " + runner2);
        } else System.out.println("vinner: " + runner3);

    }
}
