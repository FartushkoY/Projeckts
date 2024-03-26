package de.telran.lection10.sets;

import java.util.*;

public class Tasks {
    // 1. Set<String> names -----> Set<Integer> длины имен
    // 2. Имеется текст "Hello world!!!" . Вывести уникальный набор символов
    // 3.  Имеется список, отсортировать его через set
    public static void main(String[] args) {

//        Set<String> names = new TreeSet<>();
//        namesSet.add("Anna");
//        namesSet.add("Jack");
//        namesSet.add("Mandy");
//        namesSet.add("John");
//        namesSet.add("Bea");
//        namesSet.add("Tom");

        Set<String> names = Set.of("Anna", "Jack", "Mandy", "John", "Bea", "Tom");  // альтернатиыный вариант создания
        Set<Integer> namesLength = new TreeSet<>();
//
//        Iterator<String> iterator = names.iterator();
//        for (String s : names) {
//            namesLength.add(s.length());
//        }
//        System.out.println(namesLength);

        for (String s : names) {
            namesLength.add(s.length());
        }
        System.out.println(namesLength);

        String text = "Hello world!!!";
        char[] chars = text.toCharArray();
        Set<Character> charSet = new TreeSet<>();
        for (char c : chars) {
            charSet.add(c);
        }
        System.out.println(charSet);

        List<Integer> list = new ArrayList<>(List.of(2, 4, 1, 6));
        sortWithSet(list);
        System.out.println(list);


    }

    private static void sortWithSet(List<Integer> list) {
        SortedSet<Integer> set = new TreeSet<>(list);
        int i = 0;
        for (Integer value : set) {
            list.set(i++, value);
        }
    }
}
