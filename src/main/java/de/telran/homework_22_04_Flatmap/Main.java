package de.telran.homework_22_04_Flatmap;

import de.telran.lection1.house.Cat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 5, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 1);

//        С помощью flatmap:
//        a). Получить все возможные значения произведения чисел из обоих списков
        List<Integer> multiplyList = list1.stream().flatMap(el1 -> list2.stream().map(el2 -> el1 * el2)).distinct().toList();
        System.out.println(multiplyList);

//        b). Получить все возможные повторяющиеся пары чисел из обоих списков [1, 1] [5, 5]
        list1.stream().distinct().flatMap(el1 -> list2.stream().filter(el2 -> el2 == el1).distinct().map(el2 -> new Integer[]{el1, el2}))
                .forEach(i -> System.out.println(Arrays.toString(i)));
        System.out.println("--------------");


//        с). Найти все пары чисел, которые делятся друг на друга [2, 4] [3, 6] [5, 1]


        list1.stream().distinct().flatMap(el1 -> list2.stream().filter(el2 -> el2 % el1 == 0 || el1 % el2 == 0)
                .map(el2 -> new Integer[]{el1, el2})).forEach(i -> System.out.println(Arrays.toString(i)));
        System.out.println("--------------");



//        Преобразовать в List<String>
        List<Optional<String>> list = Arrays.asList(Optional.of("A"), Optional.of("B"), Optional.empty());
        List<String> stringList = list.stream().flatMap(Optional::stream).toList();
        System.out.println(stringList);
        System.out.println("----");



        Cat cat1 = new Cat("Tom", 2, "black");
        Cat cat2 = new Cat("Mikky", 1, "white");
        Cat cat3 = new Cat("Vasya", 3, "white");
        Cat cat4 = new Cat("Steve", 1, "grey");
        Cat cat5 = new Cat("Bob", 5, "black");
        List<Cat> catList = Arrays.asList(cat1, cat2, cat3, cat4, cat5);

//        Получить Map имя / цвет
        System.out.println(catList.stream().collect(Collectors.toMap(Cat::getName, Cat::getColour)));
        Map<String, String> nameColourMap = catList.stream().collect(Collectors.toMap(Cat::getName, Cat::getColour));
        System.out.println(nameColourMap);


//        Получить Map цвет / количество кошек данного цвета
        Map<String, Integer> countOfColoursMap1 = catList.stream().collect(Collectors.toMap(Cat::getColour, colour -> 1, Integer::sum));
        Map<String, Long> countOfColoursMap2 = catList.stream().collect(Collectors.groupingBy(Cat::getColour, Collectors.counting()));
        System.out.println(countOfColoursMap1);
        System.out.println(countOfColoursMap2);


//        Получить Map> цвет / список имен кошек данного цвета
        Map<String, List<String>> colourNameMap1 = catList.stream().collect(Collectors.groupingBy(Cat::getColour, Collectors.mapping(Cat::getName, Collectors.toList())));
        Map<String, List<String>> colourNameMap2 = catList.stream().collect(Collectors.groupingBy(Cat::getColour, Collectors.mapping(Cat::getName, Collectors.toList())));
        System.out.println(colourNameMap1);
        System.out.println(colourNameMap2);


//        Получить Map возраст / количество белых кошек данного возраста
        Map<Integer, Long> ageWhiteCountMap1 = catList.stream().filter(cat -> cat.getColour().equals("white")).collect(Collectors.groupingBy(Cat::getAge, Collectors.counting()));
        Map<Integer, Integer> ageWhiteCountMap2 = catList.stream().filter(cat -> cat.getColour().equals("white")).collect(Collectors.toMap(Cat::getAge, age -> 1, Integer::sum));
        System.out.println(ageWhiteCountMap1);
        System.out.println(ageWhiteCountMap2);


//        (доп. задача) Составить все возможные тройки пифагоровых чисел от 1 до 1000
//        Пифагоровой тройкой называют три натуральных числа, из которых можно составить прямоугольный треугольник
//        a^2 + b^2 = c^2
//                [3, 4, 5]
//                [6, 8, 10]

        Object[] array = IntStream.range(1, 1000).boxed().flatMap(i -> IntStream.range(1, 1000).boxed()
                .filter(j -> Math.sqrt(i * i + j * j) <= 1000 && Math.sqrt(i * i + j * j) % 1 == 0)
                .map(j -> new int[]{i, j, (int) Math.sqrt(i * i + j * j)})).toArray();
        System.out.println(Arrays.deepToString(array));



    }
}
