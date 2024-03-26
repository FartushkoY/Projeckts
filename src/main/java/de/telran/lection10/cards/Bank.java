package de.telran.lection10.cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bank {

    public static void main(String[] args) {
        MasterCard masterCard = new MasterCard(1);
        Visa visa = new Visa(2);

        System.out.println(masterCard.compareTo(visa));
        System.out.println(visa.compareTo(masterCard));

        // should be simmetric
        Card card = visa;
        System.out.println(masterCard.compareTo(card));
        System.out.println(card.compareTo(masterCard));

        List<Card> list = Arrays.asList(visa, masterCard);
        Collections.sort(list);
        System.out.println(list);
    }
}
