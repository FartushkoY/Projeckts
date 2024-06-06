package de.telran.practice_lesson_23.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class Car  implements Runnable {
    private int countLiters = 40;
    private AtomicInteger barrelGas;
    private int numberThread;

    private Lock lock;

    public Car(AtomicInteger barrelGas, int numberThread, Lock lock) {
        this.barrelGas = barrelGas;
        this.numberThread = numberThread;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            int countGas = barrelGas.get();
            System.out.println("Автомобиль " + numberThread + " узнал остаток в цистерне = " + countGas);
            Thread.sleep(500);
            if (countGas >= countLiters) {
                barrelGas.addAndGet(-countLiters);
                System.out.println("Автомобиль " + numberThread + " заправился, остаток в цистерне = " + barrelGas);
            } else {
                System.out.println("Топлива недостаточно для авто - " + numberThread);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
