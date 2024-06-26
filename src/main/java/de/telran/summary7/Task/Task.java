package de.telran.summary7.Task;

import de.telran.homeworkComparator.Employee;
import de.telran.lection1.house.Cat;


import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.reflect.Array.newInstance;

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

        String[] strings = {"Ivan", "Peter", "William", "Mary", "Jane", "Samantha"};
        System.out.println(arrayFilter(strings, s -> s.length() > 4));
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(arrayFilter(integers, i -> i % 2 == 0));
        Double[] doubles = {1.0, 2.0, 3.3, 4.9, 4.1};
        System.out.println(arrayFilter(doubles, d -> d % 1 == 0));
        Cat[] cats = {new Cat("Tom", 1, "gray"), new Cat("Murka", 2, "white"), new Cat("Havchik", 1, "black")};
        System.out.println(arrayFilter(cats, cat -> cat.getAge() == 1));
        System.out.println(arrayFilter(cats, cat -> cat.getAge() == 1).getClass());
        System.out.println(arrayFilterInArray(cats, cat -> cat.getAge() == 1).getClass());
        Cat[] cats1 = arrayFilterInArray(cats, cat -> cat.getAge() == 1);
        System.out.println(cats1.getClass());

        List<Cat> cats2 = arrayFilter(cats, cat -> cat.getAge() == 1);
        System.out.println(cats2.get(0).getClass());

        System.out.println(Arrays.toString(arrayFilterWithPredicate(strings, s -> s.length() > 4)));


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


    public static <T> List<T> arrayFilter(T[] array, Filter<T> filter) {
        return Arrays.stream(array).filter(filter::apply).toList();
    }

    //  ну или так, в массив
    public static <T> T[] arrayFilterInArray(T[] array, Filter<T> filter) {
        return Arrays.stream(array).filter(filter::apply).toArray(size -> Arrays.copyOf(array,size));
    }

    public static <T> T[] arrayFilter2(T[] array, Filter<T> filter) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isValid = filter.apply(array[i]);
            if (isValid) {
                array[j] = array[i];
            }
        }

//        T[] a = (T[]) Array.newInstance(array.getClass(), array.length);
        T[] result = Arrays.copyOf(array, j);
        return result;
    }

    public static <T> T[] arrayFilterWithPredicate(T[] array, Predicate<? super T> predicate) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isValid = predicate.test(array[i]);
            if (isValid) {
                array[j] = array[i];
            }
        }
        T[] result = Arrays.copyOf(array, j);
        return result;
    }
}

