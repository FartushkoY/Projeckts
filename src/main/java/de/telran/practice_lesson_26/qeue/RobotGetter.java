package de.telran.practice_lesson_26.qeue;

import java.util.concurrent.BlockingQueue;

public class RobotGetter implements Runnable {
    private final BlockingQueue<String> queue;
    private int numberRobot;

    public RobotGetter(BlockingQueue<String> queue, int numberRobot) {
        this.queue = queue;
        this.numberRobot = numberRobot;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(500);
                    synchronized (queue) { // только для корректной печати
                        String returnBox = queue.poll();
                        System.out.println("- " + numberRobot + " забирает со стола - " + returnBox + " остаток - " + queue.size());
                    }
                } catch (InterruptedException e) {
                    System.out.println(numberRobot + " спал и остановлен");
                    return;
                }
            } else {
                System.out.println(numberRobot + " спал и остановлен");
                return;
            }
        }
    }
}
