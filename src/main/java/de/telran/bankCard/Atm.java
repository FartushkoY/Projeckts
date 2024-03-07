package de.telran.bankCard;

import java.math.BigDecimal;

public class Atm {
    public static void main(String[] args) {
        Card card = new Card("Ivan Ivanov", BigDecimal.valueOf(5500));
        System.out.println(card);
        card.addBalance(BigDecimal.valueOf(1000));
        System.out.println("Balance: " + card.getBalance());
        card.withdraw(BigDecimal.valueOf(2000));
        System.out.println("Balance: " + card.getBalance());
        System.out.println(card);
        System.out.println("Balance in USD: " + card.getBalanceUSD());
        System.out.println("---------------------");

        CreditCard creditCard = new CreditCard("Ivan Ivanov", BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        System.out.println(creditCard);
        creditCard.withdraw(BigDecimal.valueOf(500));
        System.out.println(creditCard.getBalance());
        System.out.println("---------------------");

        DebitCard debitCard = new DebitCard("Ivan Ivanov", BigDecimal.valueOf(2000));
        System.out.println(debitCard);
        System.out.println(debitCard.getBalance());
        debitCard.getBalanceUSD();
        debitCard.addBalance(BigDecimal.valueOf(1000));
        debitCard.withdraw(BigDecimal.valueOf(500));


    }
}
