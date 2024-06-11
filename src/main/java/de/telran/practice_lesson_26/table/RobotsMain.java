package de.telran.practice_lesson_26.table;

public class RobotsMain {
    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();
        RobotGetter robotGetter1 = new RobotGetter(table,1);
        RobotGetter robotGetter2 = new RobotGetter(table,2);
        RobotPutter robotPutter = new RobotPutter(table);

        Thread threadPut = new Thread(robotPutter);
        threadPut.start();

        Thread threadPop1 = new Thread(robotGetter1);
        threadPop1.start();

        Thread threadPop2 = new Thread(robotGetter2);
        threadPop2.start();

        Thread.sleep(5_000);

        threadPut.interrupt();
        threadPop1.interrupt();
        threadPop2.interrupt();

        threadPut.join();
        threadPop1.join();
        threadPop2.join();
    }

}
