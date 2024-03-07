package de.telran.bankCard;

import java.math.BigDecimal;

public class DebitCard extends Card{
    public DebitCard(String nameOwner, BigDecimal balance) {
        super(nameOwner, balance);
    }

    @Override
    public void withdraw(BigDecimal sumWithdraw) {
        if (getBalance().subtract(sumWithdraw).compareTo(BigDecimal.valueOf(0)) >= 0) {
            setBalance(getBalance().subtract(sumWithdraw));
            System.out.println("Operation successful.  Get your money: " + sumWithdraw);
        } else {
            System.out.println("Operation denied. There is not enough money in the account");
        }
    }

    @Override
    public String toString() {
        return "DebitCard{nameOwner=" + getNameOwner() +
                ", balance=" + getBalance() +
                '}';
    }
}
