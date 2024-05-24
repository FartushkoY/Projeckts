package de.telran;

import de.telran.homeworkLinkedList.office.JobActions;

//  посчитать количество целых чисел в диапазоне от Integer.MINVALUE до Integer.MAXVALUE,
//  которые делятся на заданное целое число без остатка.
//  Решить данную задачу последовательно и параллельно в нескольких потоках. Сравнить время выполнения.
public class homework_22_05_Multithreading {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int number = 5;
        int count = 0;

        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % number == 0) count++;
        }
        long end= System.currentTimeMillis();
        System.out.println("Total divisible by " + number + "; " + count);
        System.out.println("Time elapsed: " + (end - start) + " ms");


        start = System.currentTimeMillis();
        count = 0;

        Task task1 = new Task(Integer.MIN_VALUE, Integer.MIN_VALUE / 2, 5);
        Task task2 = new Task(Integer.MIN_VALUE * 2, 0, 5);
        Task task3 = new Task(0, Integer.MAX_VALUE / 2, 5);
        Task task4 = new Task(Integer.MAX_VALUE / 2 / 2, Integer.MAX_VALUE, 5);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        Thread thread4 = new Thread(task4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        count = task1.count + task2.count + task3.count + task4.count;

        end = System.currentTimeMillis();
        System.out.println("Total divisible by "+ number + "; " +  count);
        System.out.println("Time elapsed: " + (end - start) + " ms");
    }


    static class Task implements Runnable {
        int start;
        int end;
        int count;
        int number;

        public Task(int start, int end, int number) {
            this.start = start;
            this.end = end;
            this.number = number;
        }


        @Override
        public void run() {
                for (int i = start; i < end; i++) {
                    if (i % number == 0) count++;
                }
        }
    }
}
