package de.telran.selfWork.thatIsLife;

import java.math.BigDecimal;

public class CreditCard extends Card {
//    private String ownerName;
//    private BigDecimal balance;
//    private String pin;
    private BigDecimal creditLimit;

    public CreditCard(String ownerName, BigDecimal balance, BigDecimal creditLimit) {
        super(ownerName, balance);
        this.creditLimit = creditLimit;

    }


    @Override
    public void withdraw(BigDecimal sumWithdraw) {
        if (creditLimit.add(getBalance()).compareTo(sumWithdraw) >= 0) {
            setBalance(getBalance().subtract(sumWithdraw));
        }
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ownerName='" + getOwnerName() + '\'' +
                ", balance=" + getBalance() +
                ", creditLimit=" + creditLimit +
                '}';
    }
//
//    @Override
//    public BigDecimal getBalance() {
//        return balance;
//    }

//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }

}
