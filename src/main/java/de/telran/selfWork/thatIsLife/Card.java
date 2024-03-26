package de.telran.selfWork.thatIsLife;

import java.math.BigDecimal;

public abstract class Card {
    private String ownerName;
    private BigDecimal balance;
    private String pin;

    public Card(String ownerName, BigDecimal balance) {
        this.ownerName = ownerName;
        this.balance = balance;
        pin = "0000";
    }

        public void addBalance(BigDecimal sumRecharge) {
        setBalance(getBalance().add(sumRecharge));
    }


    public abstract void withdraw(BigDecimal sumWithdraw);


    public BigDecimal getBalanceUSD() {
        BigDecimal balanceUSD = getBalance().multiply(BigDecimal.valueOf(1.09));
        return balanceUSD;
    }


    public String getOwnerName() {
        return ownerName;
    }
//
//    public void setOwnerName(String ownerName) {
//        this.ownerName = ownerName;
//    }
//
    public BigDecimal getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
