package de.telran.summary13;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpliteratorExample {

    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());

//        Spliterator<Integer> spliterator = integerList.spliterator();
//        while (spliterator.tryAdvance(System.out::println));

        Spliterator<Integer> s1 = integerList.spliterator();
        Spliterator<Integer> s2 = s1.trySplit();

        while (s1.tryAdvance(System.out::println));
        while (s2.tryAdvance(System.err::println));




    }
}
