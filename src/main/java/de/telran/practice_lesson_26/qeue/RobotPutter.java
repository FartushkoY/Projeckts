package de.telran.practice_lesson_26.qeue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class RobotPutter implements Runnable {
    private final BlockingQueue<String> queue;
    private int countBoxes = 3; // макс вместимость стола

    public RobotPutter(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(200);
                    String id = UUID.randomUUID().toString();
                    if(queue.offer(id)) {
                        System.out.println("+ Кладем на стол коробку - " + id + " остаток = " + queue.size());
                    } else {
                        System.out.println("!!! Не удалось положить на стол коробку - " + id + " остаток = " + queue.size());
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " спал и остановлен");
                    return;
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " спал и остановлен");
                return;
            }

        }

    }
}
