package de.telran.lection10.cards;

import de.telran.lection10.cards.Card;

public class MasterCard extends Card {

    private int masterCardId;

    public MasterCard(int masterCard) {
        this.masterCardId = masterCard;
    }

    @Override
    public String toString() {
        return "MasterCard{" +
                "masterCardId=" + masterCardId +
                '}';
    }

    public int getMasterCardId() {
        return masterCardId;
    }


    @Override
    public int getId() {
        return masterCardId;
    }

}
