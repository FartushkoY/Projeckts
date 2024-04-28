package de.telran.lection17;

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapMethod {
    public static void main(String[] args) {
        String[][] names = new String[3][];
        names[0] = new String[]{"Peter", "Jane", "Mark"};
        names[1] = new String[]{"Jane", "Ivan"};
        names[2] = new String[]{"Tom", "Steave"};

        Stream<String[]> stream = Arrays.stream(names);
        Stream<String> namesStream = stream.flatMap(Arrays::stream);
        namesStream.forEach(System.out::println);

        List<String> words = List.of("Hello", "World", "!!!");
        words.stream().flatMap(word -> word.chars().boxed())
                .map(Character::toString)
                .distinct()
                .forEach(System.out::println);

        String[][] strings = new String[3][];
        strings[0] = new String[]{"A", "B"};
        strings[1] = new String[]{"C", "D", "E", "F"};
        strings[2] = new String[]{"G", "H", "I"};

        for (int i = 0; i < strings.length; i++) {
            System.out.println("Retieving data from i = " + i);
            for (int j = 0; j < strings[i].length; j++) {
                System.out.println(strings[i][j]);

            }
        }

        // Аналогичная запись
//        IntStream.range(0, strings.length)
//                .peek(i -> System.out.println("Retrieving data from i = " + i))
//                .boxed()
//                .flatMap(i -> IntStream.range(0, strings[i].length)
//                        .mapToObj(j -> strings[i][j]))
//                .forEach(System.out::println);


        // Аналогичная запись
//        IntStream.range(0, strings.length)
//                .boxed()
//                .flatMap(i -> Arrays.stream(strings[i]))
//                .forEach(System.out::println);
//    }
//


        // Аналогичная запись

        IntStream.range(0, strings.length)
                .boxed()
                .flatMap(i -> Arrays.stream(strings[i]))
                .forEach(System.out::println);


//        IntStream.range(0, 3).flatMap(i -> IntStream.range(0, 3)).forEach(System.out::println);
        IntStream.range(0, 3).flatMap(i -> IntStream.of(1, 1, 1)).forEach(System.out::println);

    }


}