package de.telran.bankCard;

import java.math.BigDecimal;

public class CreditCard extends Card{
    private BigDecimal creditLimit;

    public CreditCard(String nameOwner, BigDecimal balance, BigDecimal creditLimit) {
        super(nameOwner, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(BigDecimal sumWithdraw) {
        if (getBalance().add(creditLimit).compareTo(sumWithdraw) >= 0) {
            setBalance(getBalance().subtract(sumWithdraw));
            System.out.println("Operation successful.  Get your money: " + sumWithdraw);
        } else {
            System.out.println("Operation denied. There is not enough money in the account");
        }
    }

    @Override
    public String toString() {
        return "CreditCard{nameOwner=" + getNameOwner() +
                ", creditLimit=" + creditLimit +
                ", balance=" + getBalance() +
                '}';
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
