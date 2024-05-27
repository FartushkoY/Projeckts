package de.telran.lection24;

public class SynchMethodExamples {
    public static void main(String[] args) {
        SynchMethodExamples examples = new SynchMethodExamples();

        new Thread(examples::method1, "Thread 1").start();
        new Thread(examples::method2, "Thread 2").start();



    }

    public synchronized void method1() {

        System.out.println("Method1");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void method2() {

        System.out.println("Method2");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
