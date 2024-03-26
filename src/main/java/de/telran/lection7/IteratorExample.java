package de.telran.lection7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C", "D", "E");

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        Iterator var4 = list.iterator();
//        while (var4.hasNext()) {
//            String element = (String)var4.next();
//            System.out.println(element);
//        }

//        Iterator<String> iterator = list.iterator();
//        String next = iterator.next();
//        System.out.println(next);
//        next = iterator.next();
//        System.out.println(next);
//        iterator.next();
//        iterator.next();
//        iterator.next();
//        System.out.println(iterator.hasNext());
//        if (iterator.hasNext()) {
//            iterator.next();
//        }

        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.println(next);
//        }

//        iterator = list.iterator();
//        Iterator<String> secondIterator = list.iterator();
//
//        iterator.next();
//        iterator.next();
//        iterator.next();
//        secondIterator.next();
//
//        System.out.println(iterator.next());
//        System.out.println(secondIterator.next());
//
//
//        list = new ArrayList<>();
//        list.add("One");
//        list.add("Two");
//        list.add("Three");
//        list.add("Four");
//        list.add("Five");
//
//        iterator = list.iterator();
//        iterator.next();
//        iterator.remove();
//        iterator.next();
//        iterator.remove();
//
//        System.out.println(list);
//
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//        }
//        System.out.println(list);

        // 1. Дан список из числовых данных.
        //С помощью итератора:
        //a). Напечатать только четные числа из списка.
        //b). Удалить из списка все числа, заканчивающиеся на 0.
        //c). Составить список квадратов чисел.

        List<Integer> listInt = new ArrayList<> (List.of(4, 5, 10, 3, 80, 7, 20, 14));


        Iterator<Integer> iterator1 = listInt.iterator();
        while (iterator1.hasNext()) {
            Integer elem = iterator1.next();
           if(elem %2 == 0) {
               System.out.println(elem);
           }
        }

        iterator1 = listInt.iterator();
        while (iterator1.hasNext()) {
            Integer elem = iterator1.next();
            if(elem %10 == 0) {
                iterator1.remove();
            }
        }
        System.out.println(listInt);

        iterator1 = listInt.iterator();
        List<Integer> listSqr = new ArrayList<>();
        while (iterator1.hasNext()) {
            Integer elem = iterator1.next();
            listSqr.add(elem * elem);
        }
        System.out.println(listSqr);

    }
}
