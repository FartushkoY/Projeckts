package de.telran.lection27;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class CarProduction {

    // 1 thread ---> CarDetail
    // 2 thread ---> Wheel
    // 3 thread ---> 4 Wheel + 1 CarDetail = Car

    static ArrayBlockingQueue<CarBody> queueCarBody = new ArrayBlockingQueue<>(5);
    static ArrayBlockingQueue<Wheel> queueWheels = new ArrayBlockingQueue<>(12);
    static CountDownLatch latch = new CountDownLatch(4);
    static List<Car> cars = new ArrayList<>(5);

    static class CarBody {
        String carBody = "carBody";
    }

    static class Wheel {
        String wheel = "wheel";
    }

    static class Car {
        CarBody carBody;
        List<Wheel> wheels;

        public Car(CarBody carBody, List<Wheel> wheels) {
            this.carBody = carBody;
            this.wheels = wheels;
        }
    }

    static class CarBodyFactory implements Runnable {


        @Override
        public void run() {
            int bodiesCounter = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " produced car body");
                try {
                    Thread.sleep(15000);
                    CarBody carBody = new CarBody();
                    queueCarBody.put(carBody);
                    bodiesCounter++;
                    System.out.println(Thread.currentThread().getName() + " carbody " + bodiesCounter + " is ready. In stock " + queueCarBody.size() + " carbodys");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class WheelFactory implements Runnable {


        @Override
        public void run() {
            int wheelsCounter = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " produced wheel");
                try {
                    wheelsCounter++;
                    Wheel wheel = new Wheel();
                    queueWheels.put(wheel);
//                    latch.countDown();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " wheel " + wheelsCounter + " is ready. In stock " + queueWheels.size() + " wheels");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CarFactory implements Runnable {
        CarBodyFactory carBodyFactory;
        List<WheelFactory> wheelFactoryList;

        @Override
        public void run() {
            int carCounter = 0;

            while (cars.size() < 5) {
                System.out.println("Car factory waits wheels");
//                try {
//                    latch.await();
//                } catch (InterruptedException ignore) {
//                }
                try {
                    CarBody carBody = queueCarBody.take();
                    System.out.println("Car factory got the car body");
                    List<Wheel> wheels = new ArrayList<>(4);
                    wheels.add(queueWheels.take());
                    wheels.add(queueWheels.take());
                    wheels.add(queueWheels.take());
                    wheels.add(queueWheels.take());
                    System.out.println("Car factory got the wheels");
                    Thread.sleep(10000);
                    Car car = new Car(carBody, wheels);
                    cars.add(car);
                    carCounter++;
                    System.out.println("Car " + cars.size() + " is ready");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new WheelFactory(), "Wheel factory").start();
        new Thread(new CarBodyFactory(), "Car body factory").start();
        Thread.sleep(5000);
        new Thread(new CarFactory(), "Car factory").start();
    }
}
