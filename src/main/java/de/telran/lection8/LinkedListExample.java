package de.telran.lection8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {


    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.addFirst(1);
        linkedList.addLast(10);
        linkedList.add(2, 8);
        System.out.println(linkedList);


        for (int i = 0; i < linkedList.size(); i++) { // bag practice
            System.out.println(linkedList.get(i));
        }

        for (Integer integer : linkedList) { // good
            System.out.println(integer);
        }

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        List<List<Double>> listOfLists = new LinkedList<>();
        listOfLists.add(List.of(1.0, 2.0, 3.0));
        listOfLists.add(List.of(4.0, 5.0, 6.0));
        listOfLists.add(List.of(7.0, 8.0, 9.0));

        System.out.println(listOfLists.get(1).get(2));

        for (List<Double> doubles : listOfLists) {
            for (Double d : doubles) {
                System.out.println(d);
            }
        }

    }


}