package de.telran.summary7.Task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {

//        Переписать фрагменты кода с применением стримов:
//        1)
        Set<String> names = Set.of("Ivan", "Peter", "William", "Mary");
//        Set<Integer> integerSet = new TreeSet<>();
//        for (String s : names) {
//            integerSet.add(s.length());
//        }
//        System.out.println(integerSet);

        Set<Integer> integerSet = names.stream().map(String::length).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(integerSet);

        System.out.println(getMapWithStream());


//        2)
//        public static Map<Boolean, List<Integer>> getMap() {
//            Map<Boolean, List<Integer>> map = new TreeMap<>();
//            for (int i = 0; i < 100; i++) {
//                if (i % 3 == 0) {
//                    if (map.containsKey(true)) {
//                        map.get(true).add(i);
//                    } else {
//                        map.put(true, new ArrayList<>());
//                        map.get(true).add(i);
//                    }
//                } else {
//                    if (map.containsKey(false)) {
//                        map.get(false).add(i);
//                    } else {
//                        map.put(false, new ArrayList<>());
//                        map.get(false).add(i);
//                    }
//                }
//            }
//            return map;
//        }

    }

    public static Map<Boolean, List<Integer>> getMapWithStream() {
        return IntStream.range(0, 100).boxed().collect(Collectors.partitioningBy(i -> i % 3 == 0, Collectors.toList()));
    }


//    4) Написать generic метод arrayFilter(array, filter), который принимает на вход массив array (любого типа)
//    и производит фильтрацию данных согласно реализации filter интерфейса Filter (например, через лямбда-выражение)
//    Интерфейс Filter имеет метод apply (T t), с помощью которого можно будет указывать способ фильтрации.
//    interface Filter {
//        boolean apply(T t);
//    }
//    Проверьте как работает метод на строках или других объектах.


    public static <T> T[] arrayFilter(T[] array, Filter<T> filter) {


        return null;
    }
}
