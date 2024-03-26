package de.telran.summary3;

import java.util.ArrayList;
import java.util.List;

public class ArrayListVcLinkedList {

    public static void main(String[] args) {

        int capacity = 10000;
        List<Integer> list = new ArrayList<>(capacity);
        fill(list, capacity);

        long sum = 0L;
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Sum = " + sum);
        System.out.println("Time spent: " + (end - start));


    }


    private static void fill(List<Integer> list, int capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }




}
