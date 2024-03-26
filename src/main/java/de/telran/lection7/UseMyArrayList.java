package de.telran.lection7;

import java.util.Iterator;

public class UseMyArrayList {
    public static void main(String[] args) {
        String[] data = new String[] {"A", "B", "C", "D", "E"};

        MyArrayList myList = new MyArrayList(data);
        System.out.println(myList);

        for (String s : myList) {       // чтобы это было возможно, нужно реализовать итератор в классе MyArrayList
            // some actions
            System.out.println(s);
        }

        Iterator<String> iterator = myList.reverseIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

}
