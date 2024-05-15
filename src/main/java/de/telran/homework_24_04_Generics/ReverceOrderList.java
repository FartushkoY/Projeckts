package de.telran.homework_24_04_Generics;

import de.telran.lection1.house.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.reverseOrder;

public class ReverceOrderList {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(5);
        integers.add(3);
        integers.add(4);
        integers.add(1);
        List<Integer> result = getReverceOrder(integers);
        System.out.println(integers);
        List<Integer> result1 = getReverceOrder1(integers);
        System.out.println(integers);
        System.out.println(result);
        System.out.println(result1);

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        System.out.println(getReverceOrder(strings));

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Vasya"));
        cats.add(new Cat("Murka"));
        cats.add(new Cat("Belka"));
        cats.add(new Cat("Tom"));
        cats.add(new Cat("Cat"));
        System.out.println(getReverceOrder(cats));




    }
    public static <T> List<T> getReverceOrder1(List<T> list) {
//        List<T> reverceList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size() / 2; i++) {
            T tmp = list.get(i);
            list.set(i, (list.get(list.size() - 1 - i)));
            list.set((list.size() - 1 - i), tmp);
        }
        return list;
    }


    public static <T> List<T> getReverceOrder(List<T> list) {
       List<T> reverceList = new ArrayList<>(list);
       Collections.reverse(reverceList);
       return reverceList;
    }

}
