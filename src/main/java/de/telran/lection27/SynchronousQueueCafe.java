package de.telran.lection27;

import de.telran.lection14.StringProcessor;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueCafe {
   private static SynchronousQueue<String> orderQueue = new SynchronousQueue<>(true);
   private static SynchronousQueue<String> readyCourseQueue = new SynchronousQueue<>(true);

   private static Semaphore semaphore = new Semaphore(5);

    static class Host implements Runnable {


        @Override
        public void run() {
            while (true) {

                System.out.println("Host waits for visitors...");
                try {
                    String order = orderQueue.take();
                    System.out.println("Host got an order from visitor");
                    Thread.sleep(10000);
                    System.out.println("Host cooked the order");
                    readyCourseQueue.put("Cooked: " + order);
                    System.out.println("Host gave meal to the visitor");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Visitor implements Runnable {
        String order;

        public Visitor(String order) {
            this.order = order;
        }

        @Override
        public void run() {


            try {
                System.out.println(Thread.currentThread().getName() + " comes to cafe and waits...");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " comes into cafe");
                orderQueue.put(order);
                System.out.println(Thread.currentThread().getName() + " made an order");
                System.out.println(Thread.currentThread().getName() + " waits ...");
                String readyCourse = readyCourseQueue.take();
                System.out.println(Thread.currentThread().getName() + " eats/drinks: " + readyCourse);
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " says goodbye and leaves the cafe");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Host()).start();
        Thread.sleep(5000);

//        new Thread(new Visitor("Pizza"), "Tom").start();
//        new Thread(new Visitor("Cafe"), "Jane").start();
//        new Thread(new Visitor("Pasta"), "Mark").start();

        Random random = new Random();
        int visiitorNumber = 1;
        while (true) {
            Thread.sleep(5000 + random.nextInt(5000));
            new Thread(new Visitor(String.valueOf(visiitorNumber)), "Visitor" + visiitorNumber).start();
        }
    }
}
