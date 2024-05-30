package de.telran.practice_lesson_22;

import java.util.concurrent.atomic.AtomicInteger;

public class Station {
    public static class Barrel {
        private int barrel;

        public Barrel(int barrel) {
            this.barrel = barrel;
        }

        public int getBarrel() {
            return barrel;
        }

        public Barrel() {
        }

        public void setBarrel(int barrel) {
            this.barrel = barrel;
        }

        public int addLiterInBarrel(int liter) {
            return barrel + liter;
        }

        public int getLiterFromBarrel(int liter) {
            if (liter > barrel) {
                System.out.println("It's not impossible");
            } else barrel -= liter;
            return barrel;
        }

    }

    public static class Car implements Runnable {
        Barrel barrel;
        private int liter;
        private int numberThread;

        public Car(Barrel barrel, int liter, int numberThread) {
            this.barrel = barrel;
            this.liter = liter;
            this.numberThread = numberThread;
        }

        public int getCountLiters() {
            return liter;
        }

        public void setCountLiters(int countLiters) {
            this.liter = countLiters;
        }

        @Override
        public void run() {
            int literBarrel = barrel.getBarrel();
            System.out.println("Автомобиль " + numberThread + " увидел остаток в цистерне - " + literBarrel);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (barrel.getBarrel() >= liter) {
                barrel.getLiterFromBarrel(liter);
                System.out.println("Автомобиль " + numberThread + " заправился. Остаток топлива - " + barrel);
            } else {
                System.out.println("Топлива недостаточно для авто " + numberThread);

            }
        }
    }

    public static void main(String[] args) {
        Barrel barrel = new Barrel(1000);
        int count = 0;
        Car car1 = new Car(barrel, 40, ++count);


        while (barrel.getBarrel() > 0) {

            Thread thread1 = new Thread(new Car(barrel, 40, ++count));
            Thread thread2 = new Thread(new Car(barrel, 40, ++count));
            Thread thread3 = new Thread(new Car(barrel, 40, ++count));
            System.out.println(barrel);
            thread1.start();
            thread2.start();
            thread3.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println(barrel);
    }

}
