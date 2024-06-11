package de.telran.practice_lesson_26.table;

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
                        Thread.sleep(200);
                        String id = UUID.randomUUID().toString();
                        table.put(id);
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
