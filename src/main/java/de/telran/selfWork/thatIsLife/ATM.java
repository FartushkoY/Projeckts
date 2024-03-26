package de.telran.selfWork.thatIsLife;

import java.math.BigDecimal;

public class ATM {
    private Card card;


    public void setCard(Card card, String pin) {
        if (pin.equals(card.getPin())) {
            this.card = card;
        }
    }


    public void addBalance(Card card, BigDecimal sum) {
        card.addBalance(sum);
    }


    public void withdraw(Card card, BigDecimal sum) {
        card.withdraw(sum);
    }

    public BigDecimal getBalance(Card card) {
        return card.getBalance();
    }

    public BigDecimal getBalanceUSD(Card card) {
        return card.getBalanceUSD();
    }

    public Card getInfo(Card card) {
        return card;
    }


    public void finishProcess() {
        card = null;
    }

}



