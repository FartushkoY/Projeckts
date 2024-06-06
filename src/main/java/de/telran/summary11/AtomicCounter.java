package de.telran.summary11;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicCounter {

    static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        // AtomicReference example
        String data = "string data";
        AtomicReference<String> atomicReference = new AtomicReference<>(data);
        String dataFromAtomic = atomicReference.get();
        atomicReference.getAndSet("new value");

        // AtomicInteger example
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // реализация логики counter.incrementAndGet();
                boolean success;
                do {
                    int currenValue = counter.get();
                    int old = currenValue;
                    currenValue++;
                    System.out.println(currenValue);
                    success = counter.compareAndSet(old, currenValue);
                    if (!success) System.out.println("!!!");
                } while (!success);


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // ++counter;
                System.out.println(counter.incrementAndGet());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        Thread.sleep(21_000);
        System.out.println("Final result: " + counter.get());

    }


}
