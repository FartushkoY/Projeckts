package de.telran.selfWork.thatIsLife;

import de.telran.bankCard.Card;

public class Human {
private String name;
private Card card;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, Card card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
