package de.telran.practice_lesson_25;

import java.util.UUID;

public class RobotPutter implements Runnable {

    private Table table;

    public RobotPutter(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(100);
                    String id = "box" + UUID.randomUUID();
                    table.put(id);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is awaik");
                    return;
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " your work is finished");
                return;
            }
        }
    }
}
