package de.telran.lection8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cards {
//    Дан список некоторых упорядоченных данных. Необходимо "честно" перемешать данные,
//    т.е. распределить их так, чтобы вероятность нахождения любого элемента на любом месте была бы одинакова.
//            Например, задача перемешивания колоды карт.

    public static void main(String[] args) {
        List<String> cards = new ArrayList<>(List.of("A", "B", "C", "D", "E", "F", "G", "H", "I"));
        Collections.shuffle(cards);     // библиотечное решение задачи mix cards
        mixCards(cards);
        System.out.println(cards);
        mixCards2(cards);
        System.out.println(cards);
        mixCards3(cards);
        System.out.println(cards);
    }

    public static void mixCards(List<String> cards) {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = random.nextInt(cards.size());
            swap(cards, i, j);
        }
    }
    public static void mixCards2(List<String> cards) {
        Random random = new Random();


        for (int i = 0; i < cards.size(); i++) {
            int k = random.nextInt(cards.size());
            int j = random.nextInt(cards.size());
            swap(cards, k, j);
        }
    }

    public static void mixCards3(List<String> cards) {
        Random random = new Random();
        for (int i = 1; i < cards.size(); i++) {
            swap(cards, i, random.nextInt(i + 1));
        }
    }




    public static void swap(List<String> cards, int i, int j) {
        String tmp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, tmp);
    }
}
