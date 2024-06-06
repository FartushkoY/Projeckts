package de.telran.practice_lesson_25;

public class RobotGetter implements Runnable {
    private Table table;

    public RobotGetter(Table table) {
        this.table = table;
    }


    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(100);
                    String box = table.get();
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
