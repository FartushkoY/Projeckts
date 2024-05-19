package de.telran.lection13;

import java.util.*;

public class TopKTask {

    // Дан список из n товаров. У каждого товара есть название и цена.
    // Написать метод для получения списка топ-k самых дешевых товаров, где k - входной параметр.

    public static class Item {
        String name;
        Integer price;

        public Item(String name, Integer price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item("Book", 100),
                new Item("Toy1", 50),
                new Item("Toy2", 50),
                new Item("Toy3", 12),
                new Item("Toy4", 32),
                new Item("Toy5", 23),
                new Item("Toy6", 50),
                new Item("Doll", 25));

        List<Item> top = topKWithPriorityQueue(items, 1);
        System.out.println(top);

    }

    public static List<Item> topK(List<Item> items, int k) {

        // PriorityQueue solution -----> O(n * log (n))

        Collections.sort(items, new Comparator<Item>() {  // O(n * log n)  -----> min --- O(n)
            @Override
            public int compare(Item o1, Item o2) {
                return o1.price - o2.price;
            }
        });

        List<Item> top = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            top.add(items.get(i));
        }
        return top;
    }

    public static List<Item> topKWithPriorityQueue(List<Item> items, int k) { // O(n * log k)
        Queue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.price - o1.price;
            }
        });

        for (int i = 0; i < k; i++) { // k
            queue.add(items.get(i)); // log k
        }

        for (int i = k; i < items.size(); i++) { // n - k
            Item item = items.get(i);
            if (queue.peek().price > item.price) {
                queue.poll();
                queue.add(item);
            }
        }

        // n * log k

        LinkedList<Item> result = new LinkedList<>();
        while (!queue.isEmpty()) { // k * log k
            result.addFirst(queue.poll());
        }

        return result;
    }


}