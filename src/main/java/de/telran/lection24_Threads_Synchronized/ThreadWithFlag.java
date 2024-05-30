package de.telran.lection24_Threads_Synchronized;

public class ThreadWithFlag {
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {


        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();

        Thread.sleep(5000);
//        thread.interrupt();

        flag = false;

        System.out.println("Final value: " + task.counter);


    }

    static class Task implements Runnable {
        long counter = 0;

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (counter++ % 1_000_000 == 0) {

                }
            }
        }
    }
}
