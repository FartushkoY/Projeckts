package de.telran.lection25;

public class StateAsObjectRaceCondition {

    static class BankAccount {
        private int accountA;
        private int accountB;

        public BankAccount(int accountA, int accountB) {
            this.accountA = accountA;
            this.accountB = accountB;
        }
    }

    static class AccountManager {

        private BankAccount bankAccount;

        public AccountManager(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
        }

        public synchronized void moveMoneyAToB(int amount) {
            bankAccount.accountA = bankAccount.accountA - amount;
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bankAccount.accountB = bankAccount.accountB + amount;
        }

        public synchronized BankAccount getBankAccount() {
            BankAccount copy = new BankAccount(bankAccount.accountA, bankAccount.accountB);
//            return bankAccount;
            return copy;
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000, 1000);
        AccountManager accountManager = new AccountManager(bankAccount);

        new Thread(() -> {
            while (true) {
                accountManager.moveMoneyAToB(10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            BankAccount account = accountManager.getBankAccount();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("accountA: " + account.accountA + ", accountB: " + account.accountB +
                    ", total balance: " + (account.accountA + account.accountB));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }




}




