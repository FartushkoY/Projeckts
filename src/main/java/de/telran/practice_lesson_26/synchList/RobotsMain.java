package de.telran.practice_lesson_26.synchList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RobotsMain {
    public static void main(String[] args) throws InterruptedException {
        int countPops = 2;
        Thread[] threadPops = new Thread[countPops];

        List<String> box = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < countPops; i++) {
            threadPops[i] = new Thread(new RobotGetter(box,i+1));
        }
        RobotPutter robotPut = new RobotPutter(box);

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
