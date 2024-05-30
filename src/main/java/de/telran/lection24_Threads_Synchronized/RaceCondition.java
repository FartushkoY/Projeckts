package de.telran.lection24_Threads_Synchronized;

public class RaceCondition {

    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();

        Thread.sleep(25_000);
        System.out.println("Final value: " + counter);
    }


    static class Task implements Runnable {


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
               counter++;
                // tmp = counter
                // tmp++
                // counter = tmp
                System.out.println(Thread.currentThread().getName()+ " : " + counter);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
