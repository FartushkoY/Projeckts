package de.telran.homework_27_05_Threads;

public class BankAccount {
    private int sum;

    public BankAccount(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "sum=" + sum +
                '}';
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    //  сделала sout в методах в начале и в конце для наглядности, чтобы я могла уидеть, что там происходит
//   так-то понятно, что они не нужны
    public synchronized void deposit(int amount) {
        System.out.println(sum);
        sum += amount;
        System.out.println(sum);
        System.out.println("---");
    }


    public synchronized void withdraw(int amount) {
        System.out.println(sum);
        if (sum >= amount) {
            sum -= amount;
        } else System.out.println("Недостаточно средств на счете");
        System.out.println(sum);
        System.out.println("---");
    }


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        Thread thread1 = new Thread(() -> bankAccount.deposit(1000));
        Thread thread5 = new Thread(() -> bankAccount.withdraw(1000));
        Thread thread2 = new Thread(() -> bankAccount.withdraw(1000));
        Thread thread3 = new Thread(() -> bankAccount.deposit(500));
        Thread thread4 = new Thread(() -> bankAccount.withdraw(1000));

        thread1.start();
        thread5.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread5.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(bankAccount);
    }
}
