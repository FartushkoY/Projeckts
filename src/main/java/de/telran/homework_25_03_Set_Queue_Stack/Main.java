package de.telran.homework_25_03_Set_Queue_Stack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        1. Имеется два набора элементов Set. Создать Set, в котором бы находились:

        Set<String> stringSet1 = new TreeSet<>();
        stringSet1.add("A");
        stringSet1.add("B");
        stringSet1.add("C");
        stringSet1.add("D");
        stringSet1.add("E");
        stringSet1.add("F");

        Set<String> stringSet2 = new TreeSet<>();
        stringSet2.add("D");
        stringSet2.add("E");
        stringSet2.add("F");
        stringSet2.add("G");
        stringSet2.add("H");
        stringSet2.add("I");
        stringSet2.add("J");

        //        все элементы из двух наборов
        Set<String> stringSet = new TreeSet<>();
        stringSet.addAll(stringSet1);
        stringSet.addAll(stringSet2);
        System.out.println(stringSet);

//    только общие для двух наборов элементы,
        Set<String> commonElementsSet = new TreeSet<>();
        for (String string : stringSet1) {
            if (stringSet2.contains(string)) {
                commonElementsSet.add(string);
            }
        }
        System.out.println(commonElementsSet);

//     только элементы, которые присутствуют в первом наборе и отсутствуют во втором
        Set<String> elementsOnlyInFirstSet = new TreeSet<>();
        for (String s : stringSet1) {
            if (!stringSet2.contains(s)) {
                elementsOnlyInFirstSet.add(s);
            }
        }
        System.out.println(elementsOnlyInFirstSet);

//        Имеется очередь Queue. Написать метод, возвращающий очередь Queue,
//        в которой элементы расположены в обратном порядке.

        Deque<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(queue);

        System.out.println(sortInReverceOrder(queue));

    }

    private static Queue<Integer> sortInReverceOrder(Deque<Integer> queue) {
        Queue<Integer> reverceQueue = new LinkedList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
//            Integer tmp= queue.removeLast();
            reverceQueue.add(queue.removeLast());
        }
        return reverceQueue;
    }
}
