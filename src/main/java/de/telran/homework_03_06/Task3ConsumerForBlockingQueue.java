package de.telran.homework_03_06;

import java.util.Random;

public class Task3ConsumerForBlockingQueue {
    static volatile boolean flag = true;
    static class Producer implements Runnable {
        ReentrantLockArrayDeque<String> deque;

        public Producer(ReentrantLockArrayDeque<String> deque) {
            this.deque = deque;
        }

        @Override
        public void run() {
            while (flag) {
                String[] strings = {"Hello", "lesson", "party", "summer", "sun", "OK", "exit", "bye", "super"};
                Random random = new Random();
                int ind = random.nextInt(strings.length );
                deque.putLast(strings[ind]);
            }
            return;
        }
    }


    static class Consumer implements Runnable {
        ReentrantLockArrayDeque<String> deque;

        public Consumer(ReentrantLockArrayDeque<String> deque) {
            this.deque = deque;
        }

        @Override
        public void run() {
            while (flag) {
                String data = deque.takeFirst();
                if (data.equals("exit")) {
                    System.out.println("End the program");
                    flag = false;
//                    return;
                }
            }
        }


        public static void main(String[] args) {
            ReentrantLockArrayDeque<String> deque = new ReentrantLockArrayDeque<>(5);

            Producer producer = new Producer(deque);
            Consumer consumer1 = new Consumer(deque);
            Consumer consumer2 = new Consumer(deque);

            new Thread(producer, "Producer").start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(consumer1, "Consumer").start();
            new Thread(consumer2, "Consumer").start();
        }
    }
}
