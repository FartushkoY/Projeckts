package de.telran.homework_27_05_Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic {
    private AtomicInteger sum;

    public BankAccountAtomic(AtomicInteger sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "sum=" + sum +
                '}';
    }

    public int getSum() {
        return sum.get();
    }

    public void setSum(int amount) {
        sum.set(amount);
    }

    //  сделала sout в методах в начале и в конце для наглядности, чтобы я могла уидеть, что там происходит
//   так-то понятно, что они не нужны
    public void deposit(int amount) {
        System.out.println(sum);
        sum.addAndGet(amount);
        System.out.println(sum);
        System.out.println("---");
    }


    public void withdraw(int amount) {
        System.out.println(sum);
        boolean success = false;
        if (sum.get() >= amount) {
//            do {
//                int old = sum.get();
//                sum.addAndGet(-amount);
//                if (sum.get() == old - amount) {
//                    success = true;
//                }
//            } while (!success);


            // или? думаю, это более правильный вариант
            do {
                int old = sum.get();
                int currentValue = old - amount;
                success = sum.compareAndSet(old, currentValue);
            } while (!success);

        }
        System.out.println(sum);
        System.out.println("---");
    }


    public static void main(String[] args) {

        BankAccountAtomic bankAccount1 = new BankAccountAtomic(new AtomicInteger(1000));
        BankAccountAtomic bankAccount2 = new BankAccountAtomic(new AtomicInteger(500));
        Thread thread1 = new Thread (() -> bankAccount1.deposit(1000));
        Thread thread2 = new Thread (() -> bankAccount1.withdraw(1000));
        Thread thread3 = new Thread (() -> bankAccount1.withdraw(1000));
        Thread thread4 = new Thread (() -> bankAccount1.deposit(500));
        Thread thread5 = new Thread (() -> bankAccount2.withdraw(30));
        Thread thread6 = new Thread (() -> bankAccount2.deposit(130));
        Thread thread7 = new Thread (() -> bankAccount2.withdraw(200));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bankAccount1);
        System.out.println(bankAccount2);



    }
}
