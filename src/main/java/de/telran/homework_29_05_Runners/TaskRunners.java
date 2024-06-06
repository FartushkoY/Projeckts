package de.telran.homework_29_05_Runners;

import java.util.Random;

public class TaskRunners {
    static class Bridge {
        private int runningTime;

        public Bridge(int runningTime) {
            this.runningTime = runningTime;
        }

        public int getRunningTime() {
            return runningTime;
        }

        public synchronized void crossBridge() {


        }
    }

    static class Runner implements Runnable {

        private String name;
        private long time;
        private Bridge bridge;

        public Runner(String name, Bridge bridge) {
            this.name = name;
            this.time = 0;
            this.bridge = bridge;
        }

        @Override
        public String toString() {
            return "Runner{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
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
            System.out.println("Start " + Thread.currentThread().getName());
            int run = random.nextInt(5000) + 10000;
            try {
                Thread.sleep(run);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (bridge) {
                System.out.println(Thread.currentThread().getName() + " runs across the bridge");
                try {
                    Thread.sleep(bridge.getRunningTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " ran across the bridge");
            }

            run = random.nextInt(5000);
            try {
                Thread.sleep(run);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("End " + Thread.currentThread().getName());
            long end = System.currentTimeMillis();
            setTime(end - start);
        }

        public void running() {

        }


    }





    public static void main(String[] args) {
        Bridge bridge = new Bridge(3000);
        Runner runner1 = new Runner("Runner1", bridge);
        Runner runner2 = new Runner("Runner2", bridge);
        Runner runner3 = new Runner("Runner3", bridge);

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

        System.out.println(runner1);
        System.out.println(runner2);
        System.out.println(runner3);
        System.out.println();




        if (runner1.getTime() < runner2.getTime() && runner1.getTime() < runner3.getTime()) {
            System.out.println("vinner: " + runner1);
        } else if (runner2.getTime() < runner1.getTime() && runner2.getTime() < runner3.getTime()) {
            System.out.println("vinner: " + runner2);
        } else System.out.println("vinner: " + runner3);

    }
}
