package de.telran.selfWork.thatIsLife;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Card creditCard = new CreditCard("John Smith", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));
        ATM atm = new ATM();
        atm.setCard(creditCard, "1234");
        System.out.println(atm.getInfo(creditCard));
        System.out.println(atm.getBalance(creditCard));
        System.out.println(atm.getBalanceUSD(creditCard));
        atm.addBalance(creditCard, BigDecimal.valueOf(500));
        System.out.println(atm.getBalance(creditCard));
        atm.withdraw(creditCard, BigDecimal.valueOf(5000));
        System.out.println(atm.getBalance(creditCard));

    }
}
