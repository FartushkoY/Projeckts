package de.telran.practice_lesson_22.synch;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GasStationSync {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        AtomicInteger gas = new AtomicInteger(1000);

        int count = 0;
        while (gas.get() > 0) {
//            Thread thread1 = new Thread(new Car(gas, count + 1));
//            Thread thread2 = new Thread(new Car(gas, count + 2));
//            Thread thread3 = new Thread(new Car(gas, count + 3));
//            thread1.start();
//            thread2.start();
//            thread3.start();
//
//            try {
//                thread1.join();
//                thread2.join();
//                thread3.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            count += 3;
        }


    }
}
