package de.telran.practice_lesson_26.table;

public class RobotGetter implements Runnable {
    private Table table;
    private int numberRobot;

    public RobotGetter(Table table, int numberRobot) {
        this.table = table;
        this.numberRobot = numberRobot;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(500);
                    String box = table.pop(numberRobot);
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
