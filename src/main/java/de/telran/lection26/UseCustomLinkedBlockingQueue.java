package de.telran.lection26;

public class UseCustomLinkedBlockingQueue {
    static class Producer implements Runnable {
        CustomLinkedBlockingQueue<String> queue;

        public Producer(CustomLinkedBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                String data = "Data " + i;
                System.out.println(Thread.currentThread().getName() + " created: " + data);
                queue.put(data);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class Consumer implements Runnable {

        CustomLinkedBlockingQueue<String> queue;

        public Consumer(CustomLinkedBlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                String data = queue.take();
                System.out.println(Thread.currentThread().getName() + " processing: " + data + ", queue size: " + queue.size());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        CustomLinkedBlockingQueue<String> queue = new CustomLinkedBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer, "Producer1").start();

        new Thread(consumer, "Consumer1").start();

    }
}
