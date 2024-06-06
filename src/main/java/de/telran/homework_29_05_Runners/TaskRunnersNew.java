package de.telran.homework_29_05_Runners;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TaskRunnersNew {
    static Object mutex = new Object();

    static class Runner implements Runnable, Comparable<Runner> {

        private String name;
        private long time;


        public Runner(String name) {
            this.name = name;
            this.time = 0;

        }

        @Override
        public String toString() {
            return name + ", time=" + time;
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
            System.out.println("Start " + Thread.currentThread().getName());
            running();
            crossBridge(3000);
            running();
            System.out.println("End " + Thread.currentThread().getName());
            long end = System.currentTimeMillis();
            setTime(end - start);
        }

        public void running() {
            System.out.println(Thread.currentThread().getName() + " runs");
            Random random = new Random();
            int run = random.nextInt(5000) + 5000;
            try {
                Thread.sleep(run);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void crossBridge(int time) {
            synchronized (mutex) {
                System.out.println(Thread.currentThread().getName() + " at the beginning of the bridge");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " at the end of the bridge");
            }
        }


        @Override
        public int compareTo(Runner o) {
            return Long.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object start = new Object();
        Runner runner1 = new Runner("Runner1");
        Runner runner2 = new Runner("Runner2");
        Runner runner3 = new Runner("Runner3");
        Runner runner4 = new Runner("Runner4");
        Runner runner5 = new Runner("Runner5");
        Runner runner6 = new Runner("Runner6");

        Thread thread1 = new Thread(runner1, "Runner1");
        Thread thread2 = new Thread(runner2, "Runner2");
        Thread thread3 = new Thread(runner3, "Runner3");
        Thread thread4 = new Thread(runner4, "Runner4");
        Thread thread5 = new Thread(runner5, "Runner5");
        Thread thread6 = new Thread(runner6, "Runner6");
        Thread.sleep(5000);


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();

        System.out.println(runner1);
        System.out.println(runner2);
        System.out.println(runner3);
        System.out.println(runner4);
        System.out.println(runner5);
        System.out.println(runner6);

        List<Runner> runners = Arrays.asList(runner1, runner2, runner3, runner4, runner5, runner6);
        Runner vinner = runners.stream().sorted().findFirst().orElse(new Runner(""));
        System.out.println("Vinner: " + vinner);

    }
}
