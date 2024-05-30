package de.telran.lection25;

public class ThreadExceptionExamples {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main start");
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.err.println("General logic for exception in " + thread.getName() + ", exception message:" + exception);
        });

        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    System.out.println(i++);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000);
        System.out.println(1 / 0);

        System.out.println("Some main logic");
        System.out.println("Main end");
    }

}
