package de.telran.homework_03_06;

public class UseReentrantLockArrayDequeu {
    static class Producer implements Runnable {
        ReentrantLockArrayDeque<Integer> deque;

        public Producer(ReentrantLockArrayDeque<Integer> deque) {
            this.deque = deque;
        }

        @Override
        public void run() {
            for (int i = 0; i < 7; i++) {
                if (i % 2 == 0) {
                    deque.putFirst(i);
                } else deque.putLast(i);
            }
        }
    }


    static class Consumer implements Runnable {
        ReentrantLockArrayDeque<Integer> deque;

        public Consumer(ReentrantLockArrayDeque<Integer> deque) {
            this.deque = deque;
        }

        @Override
        public void run() {
            while (true) {
                deque.takeLast();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                deque.takeFirst();
            }
        }
    }


    public static void main(String[] args) {
        ReentrantLockArrayDeque<Integer> deque = new ReentrantLockArrayDeque<>(5);

        Producer producer1 = new Producer(deque);
        Consumer consumer1 = new Consumer(deque);

        new Thread(producer1, "Producer1").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(consumer1, "Consumer1").start();
    }
}
