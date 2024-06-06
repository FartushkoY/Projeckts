package de.telran.lection27;

import de.telran.practice_lesson_22.synch.Car;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class CarProduction {

    // 1 thread ---> CarDetail
    // 2 thread ---> Wheel
    // 3 thread ---> 4 Wheel + 1 CarDetail = Car

    static ArrayBlockingQueue queueCarBody = new ArrayBlockingQueue<>(5);
    static ArrayBlockingQueue queueWheels = new ArrayBlockingQueue<>(12);
    static CountDownLatch latch = new CountDownLatch(4);

    static class CarBody implements Runnable {
        String carBody = "carBody";

        @Override
        public void run() {
            int bodiesCounter = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " produced car body");
                try {
                    Thread.sleep(15000);
                    queueCarBody.put(carBody);
                    bodiesCounter++;
                    System.out.println(Thread.currentThread().getName() + " carbody "  + bodiesCounter + " is ready. In stock " + queueCarBody.size() + " carbodys");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Wheel implements Runnable {
        String wheel = "wheel";

        @Override
        public void run() {
            int wheelsCounter =0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " produced wheel");
                try {
                    wheelsCounter++;
                    queueWheels.put(wheel + wheelsCounter);
                    latch.countDown();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " wheel " + wheelsCounter + " is ready. In stock " + queueWheels.size() + " wheels");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Car implements Runnable{
        CarBody carBody;
        List<Wheel> wheelList;

        @Override
        public void run() {

            while (true) {
                System.out.println("Car factory waits wheels");
                try {
                    latch.await();
                } catch (InterruptedException ignore) {
                }
                try {
                    queueCarBody.take();
                    queueWheels.take();
                    queueWheels.take();
                    queueWheels.take();
                    queueWheels.take();
                    Thread.sleep(10000);
                    System.out.println("Car is ready");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Wheel(), "Wheel factory").start();
        new Thread(new CarBody(), "Car body factory").start();
        Thread.sleep(5000);
        new Thread(new Car(), "Car factory").start();
    }
}
