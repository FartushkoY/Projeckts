package de.telran.practice_lesson_26.qeue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class RobotsMain {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3, true);

        int countPops = 2;
        Thread[] threadPops = new Thread[countPops];

        for (int i = 0; i < countPops; i++) {
            threadPops[i] = new Thread(new RobotGetter(queue,i+1));
        }
        RobotPutter robotPut = new RobotPutter(queue);

        Thread threadPut = new Thread(robotPut);
        threadPut.start();

        for (int i = 0; i < countPops; i++) {
            threadPops[i].start();
        }

        Thread.sleep(5_000);

        threadPut.interrupt();
        for (int i = 0; i < countPops; i++) {
            threadPops[i].interrupt();
        }

        System.out.println(" == Конец главного потока! == ");
    }
}
