package de.telran.lection10.cards;

public abstract class Card implements Comparable<Card>{
    public abstract int getId();


    @Override
    public int compareTo(Card o) {
        return this.getId() - o.getId();
    }


}
