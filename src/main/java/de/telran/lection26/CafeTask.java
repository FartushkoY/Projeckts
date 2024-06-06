package de.telran.lection26;

public class CafeTask {
    static Object visitorComes = new Object();
    static Object coffeIsReady = new Object();


    static class Waiter implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is waiting for a visitor");
            synchronized (visitorComes) {
                try {
                    visitorComes.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " receives order, started to make coffe");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (coffeIsReady) {
                coffeIsReady.notify();
                System.out.println(Thread.currentThread().getName() + " ");
            }
        }
    }


    static class Visitor implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " comes in the cafe");
            synchronized (visitorComes) {
                visitorComes.notify();
            }
            System.out.println(Thread.currentThread().getName() + " makes order");
            synchronized (coffeIsReady) {
                try {
                    coffeIsReady.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " drinks coffee");


        }
    }

    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        Waiter waiter = new Waiter();
        new Thread(visitor).start();
        new Thread(waiter).start();
    }
}
