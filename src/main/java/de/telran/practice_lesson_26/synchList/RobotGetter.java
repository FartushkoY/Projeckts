package de.telran.practice_lesson_26.synchList;

import java.util.List;

public class RobotGetter implements Runnable {
    private List<String> boxes;
    private int numberRobot;

    public RobotGetter(List<String> box, int numberRobot) {
        this.boxes = box;
        this.numberRobot = numberRobot;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(500);
                    while (boxes.isEmpty()) {
                        synchronized (boxes) {
                            boxes.wait();
                        }
                    }
                    synchronized (boxes) {
                        String returnBox = boxes.remove(0);
                        System.out.println("- " + numberRobot + " забирает со стола - " + returnBox + " остаток - " + boxes.size());
                        boxes.notify();
//                        boxes.notifyAll();
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
