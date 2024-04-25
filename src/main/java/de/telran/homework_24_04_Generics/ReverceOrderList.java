package de.telran.homework_24_04_Generics;

import de.telran.lection1.house.Cat;

import java.util.ArrayList;
import java.util.List;

public class ReverceOrderList {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        System.out.println(getReverceOrder(integers));

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

    public static <T> List<T> getReverceOrder(List<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            T tmp = list.get(i);
            list.set(i, (list.get(list.size() - 1 - i)));
            list.set((list.size() - 1 - i), tmp);
        }
        return list;
    }

}
