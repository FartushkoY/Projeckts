package de.telran.lection25;

import de.telran.lection1.house.Cat;

public class BankAccountWithInnerMutex {
    private int balance;

    private Object mutex = new Object();

    public int getBalance() {
        synchronized (mutex) {
            return balance;
        }
    }

    public void setBalance(int balance) {
        synchronized (mutex) {
            this.balance = balance;
        }
    }

    public void deposit(int amount) {
        synchronized (mutex) {
            balance = balance + amount;
        }
    }


    public static void main(String[] args) {
        BankAccountWithInnerMutex bankAccount1 = new BankAccountWithInnerMutex();
        bankAccount1.setBalance(1000);

        Object myMutex = new Cat("MyCat");


        // deposit
        new Thread(() -> {
            synchronized (myMutex) {
                int amount = 100;
                int currentBalance = bankAccount1.getBalance();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bankAccount1.setBalance(currentBalance + amount);
            }
        }).start();

        // deposit
        new Thread(() -> {
            synchronized (myMutex) {
                int amount = 100;
                int currentBalance = bankAccount1.getBalance();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bankAccount1.setBalance(currentBalance + amount);
            }
        }).start();

        // deposit
        new Thread(() -> {
            synchronized (myMutex) {
                int amount = 100;
                int currentBalance = bankAccount1.getBalance();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bankAccount1.setBalance(currentBalance + amount);
            }
        }).start();

        // deposit
//        new Thread(() -> {
//            bankAccount1.deposit(100);
//        }).start();
//
//        // deposit
//        new Thread(() -> {
//            bankAccount1.deposit(100);
//        }).start();
//
//        // deposit
//        new Thread(() -> {
//            bankAccount1.deposit(100);
//        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bankAccount1.getBalance());

    }

}
