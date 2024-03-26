package de.telran.homeworkSets;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class HomeworkSets {
    public static void main(String[] args) {
        Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(5);
        integerSet.add(2);
        integerSet.add(10);
        integerSet.add(15);
        integerSet.add(54);
        integerSet.add(9);
        integerSet.add(33);
        System.out.println(integerSet);

//        Найти заданное число 10, самое большое, самое маленькое

        SortedSet<Integer> sortedSet = (SortedSet<Integer>) integerSet;
        System.out.println(sortedSet.contains(10));
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());

//        Вывести все четные числа
        for (Integer i : integerSet) {
            if (i %2 == 0) {
                System.out.println(i);
            }
        }

        //        Получить список всех чисел в обратном порядке
        NavigableSet<Integer> navigableSet = (NavigableSet<Integer>) integerSet;
        NavigableSet<Integer> descendingSet = navigableSet.descendingSet();
        System.out.println(descendingSet);


//        Получить список всех чисел меньше 7
        SortedSet<Integer> subSet = sortedSet.subSet(sortedSet.first(), 7);
        System.out.println(subSet);
    }
}
