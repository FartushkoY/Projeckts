package de.telran.practice_lesson_25;

public class RobotMain {
    public static void main(String[] args) throws InterruptedException {

        Table table = new Table();
        RobotPutter robotPutter = new RobotPutter(table);
        RobotGetter robotTaker = new RobotGetter(table);

        Thread threadPutter = new Thread(robotPutter);
        threadPutter.start();
        Thread threadTaker = new Thread(robotTaker);
        threadTaker.start();

        Thread.sleep(5000);

        threadPutter.interrupt();
        threadTaker.interrupt();

        threadPutter.join();
        threadTaker.join();

    }


}
