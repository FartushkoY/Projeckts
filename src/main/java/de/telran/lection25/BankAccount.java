package de.telran.lection25;

public class BankAccount {
    private int balance;

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        balance = balance + amount;
    }

//    public static synchronized void deposit(int amount, BankAccount account) {
//        account.setBalance(account.getBalance() + amount);
//    }

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setBalance(1000);

        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.setBalance(500);
        // deposit
        new Thread(() -> {
            bankAccount2.deposit(100);
//            deposit(100, bankAccount2);
        }).start();


        // deposit
        new Thread(() -> {
            synchronized (bankAccount1) {
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
            synchronized (bankAccount1) {
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
            bankAccount1.deposit(100);
//            deposit(100, bankAccount1);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bankAccount1.getBalance());

    }
}
