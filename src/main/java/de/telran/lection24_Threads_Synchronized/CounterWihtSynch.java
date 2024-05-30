package de.telran.lection24_Threads_Synchronized;

public class CounterWihtSynch {

    static int counter = 0;
    static Object mutex = new Object();

    public static void main(String[] args) {



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
