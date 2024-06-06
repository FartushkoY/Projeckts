package de.telran.practice_lesson_24;

public class SimpleInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Task(2, 400_000));
        Thread thread2 = new Thread(new Task(400_001, 700_000));
        Thread thread3 = new Thread(new Task(700_001, 1_000_000));

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(5000);
        thread1.interrupt();

        Thread.sleep(5000);
        thread2.interrupt();

        Thread.sleep(5000);
        thread3.interrupt();


    }
}

class Task implements Runnable {
    int start;
    int end;
    int primeCount;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        for (int i = start; i < end; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is awaken, i = " + i );
                return;
            }

            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primeCount++;
            if (Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " finished by signal, i = " + i);
                return;
            }
        }
    }
}
