package de.telran.homework_29_03_Map_PriorityDequeue;

import java.util.*;

public class Item {
    private String title;
    private double price;

    public Item(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
    public static List<Item> getTopK(List<Item> itemList, int k) {
        List<Item> topKList = new ArrayList<>(k);
        Collections.sort(itemList, new ItemsByPriceComparator());
        for (int i = 0; i < k; i++) {
            topKList.add(itemList.get(i));
        }
        return topKList;
    }


    public static class ItemsByPriceComparator  implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return (o1.price < o2.price ? -1 : (o1.price > o2.price ? 1 : 0));
        }
    }



    public static void main(String[] args) {
        Item item1 = new Item("Title1", 12.5);
        Item item2 = new Item("Title2", 10.75);
        Item item3 = new Item("Title3", 2.0);
        Item item4 = new Item("Title4", 15.0);
        Item item5 = new Item("Title5", 4.5);
        Item item6 = new Item("Title6", 11.3);
        Item item7 = new Item("Title7", 8.5);
        Item item8 = new Item("Title8", 7.7);

        List<Item> itemList = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8);
        System.out.println(itemList);

        System.out.println(getTopK(itemList, 3));
    }
}
