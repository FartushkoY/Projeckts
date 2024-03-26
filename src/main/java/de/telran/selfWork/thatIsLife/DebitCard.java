package de.telran.selfWork.thatIsLife;

import java.math.BigDecimal;

public class DebitCard extends Card{

//    private String ownerName;
//
//    private BigDecimal balance;
//    private String pin;


    public DebitCard(String ownerName, BigDecimal balance) {
        super(ownerName, balance);
    }

    @Override
    public void withdraw(BigDecimal sumWithdraw) {
        if (sumWithdraw.compareTo(getBalance()) <= 0) {
            setBalance(getBalance().subtract(sumWithdraw));
        }
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "ownerName='" + getOwnerName() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }

//    @Override
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    @Override
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }

//    @Override
//    public String getPin() {
//        return pin;
//    }
}
