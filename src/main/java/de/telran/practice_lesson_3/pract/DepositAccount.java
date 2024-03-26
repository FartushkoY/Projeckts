package de.telran.practice_lesson_3.pract;

import java.time.LocalDate;

public class DepositAccount extends ClientAccount{

    private double maxDeposit;

    public DepositAccount(double maxDeposit, String accountOwner, String accountNumber) {
        this.maxDeposit = maxDeposit;
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
        this.status = StatusAccount.OPEN;
        this.openDate = "today";
    }

    @Override
    public double withdrawBalance(double sum) {
        if (sum <= balance) {
            balance -= sum;
            System.out.println("Your balance has been changed");
        } else {
            System.out.println("You try to withdraw more as you have");
        }
        return balance;
    }

    @Override
    public void addBalance(double sum) {
        if (sum <= maxDeposit) {
            balance += sum;
            System.out.println("Your balance has been changed");
        } else {
            System.out.println("You try to deposit more as allowed");
        }
    }

    public double getMaxDeposit() {
        return maxDeposit;
    }

    public void setMaxDeposit(double maxDeposit) {
        if(maxDeposit >= 0) {
            this.maxDeposit = maxDeposit;
        }
        else {
            System.out.println("Incorrect max sum deposit, try again.");
        }
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "maxDeposit=" + maxDeposit +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                "} ";
    }
}

//    Депозитный счет (DepositAccount) - может быть только положительным или 0
//        доп.характеристики: макс.сумма пополнения.
//        Поведение: Установить макс.сумма пополнения, Получить макс.сумма пополнения.