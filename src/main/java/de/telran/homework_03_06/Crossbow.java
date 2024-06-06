package de.telran.homework_03_06;

import java.util.Scanner;

public class Crossbow {
    private int arrows = 5;
    static Object noArrows = new Object();
    static Object haveArrows = new Object();


    // When the arrows end, the wait() method is called and releases.
    public void fire() {
        while (true) {
            for (int idx = arrows; idx >= 0; idx--) {

                if (idx != 0) {
                    System.out.println("The arrow is " + (arrows - idx + 1) + " right on the target!");
                } else {

                    System.out.println("The arrows are over");
                    arrows = 0;
                    System.out.println("Count arrows " + arrows);
                    System.out.println("Carry a new quiver with arrows!!");

                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (noArrows) {
                noArrows.notify();
            }

        synchronized (haveArrows) {
            try {
                haveArrows.wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


    // reload() brings new arrows, calls the notify() method, which awakens the thread
    public void reload() {
        while (true) {
            synchronized (noArrows) {
                try {
                    noArrows.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Scanner scanner = new Scanner(System.in);
                System.out.print("How many arrows you need?");
                arrows = scanner.nextInt();
                System.out.println("New arrows on the way!");
                System.out.println("Count arrows = " + arrows);
            }
            synchronized (haveArrows) {
                haveArrows.notify();
            }
        }
    }

    public static void main(String[] args) {

        Crossbow crossbow = new Crossbow();

        Thread robinHood = new Thread(crossbow::fire);
        Thread servant = new Thread(crossbow::reload);

        robinHood.start();



        servant.start();
    }
}


//    Доработать логику, чтобы:
//
//        - стрельба продолжалась бесконечно
//        - количество приносимых стрел каждый раз определял бы пользователь, вводя число arrows через консоль
