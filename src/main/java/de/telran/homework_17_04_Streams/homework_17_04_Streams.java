package de.telran.homework_17_04_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class homework_17_04_Streams {
    public static void main(String[] args) {
//        Посчитать количество неповторяющихся слов в списке
        List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Four", "One", "Five", "Six");
        System.out.println(stringList.stream().distinct().count());

//        Посчитать количество людей с именем "Tom" в списке имен
        List<String> names = Arrays.asList("Tom", "Ben", "Frank", "Tom", "Olaf", "Tom", "John");
        System.out.println(names.stream().filter(string -> string.equals("Tom")).count());

//        Из списка имен вывести первое по алфавиту, предпоследнее по алфавиту
        System.out.println(names.stream().sorted().findFirst().orElse("exeption"));
        System.out.println(names.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse("oops"));

//        Посчитать количество чисел от 1 до 1000, которые делятся на 7
        List<Integer> oneThousand = Stream.iterate(1, i -> i + 1).limit(1000).toList();
        System.out.println(oneThousand.stream().filter(integer -> integer % 7 == 0).count());
        // или другой вариант записи
        System.out.println(Stream.iterate(1, i -> i + 1).limit(1000).toList().stream().filter(integer -> integer % 7 == 0).count());

//        Посчитать сумму квадратов чисел от 1 до 100
        System.out.println(oneThousand.stream().filter(integer -> integer <= 100).map(i -> i = i * i).mapToInt(Integer::intValue).sum());
        // или другой вариант
        System.out.println(Stream.iterate(1, i -> i + 1).limit(100).toList().stream().map(i -> i = i * i).mapToInt(Integer::intValue).sum());

//        Проверить, все ли числа из списка четные
        List<Integer> integers = Arrays.asList(1, 2, 5, 7, 12, 10);
        System.out.println(integers.stream().allMatch(integer -> integer % 2 == 0));


//        Переписать через стримы фрагменты кода:
//        for (String s : strings) {
//            System.out.println(s);
//        }
        List<String> strings = Arrays.asList("A", "C", "B", "C", "C", "B");
        strings.stream().forEach(System.out::println);

//        public static List method(List<String> strings) {
//            List result = new ArrayList<>();
//            for (String s : strings) {
//                if (!result.contains(s)) {
//                    result.add(s);
//                }
//            }
//            return result;
//        }


    }
    public static List methodWithStream(List<String> strings){
        List<String> result = strings.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        return result;
    }


}
