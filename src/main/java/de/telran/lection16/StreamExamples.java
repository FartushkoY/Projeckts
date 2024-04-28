package de.telran.lection16;

import de.telran.homeworkComparator.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("A", "B", "C", "D", "F");

        List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        List<String> result = stringList.stream().filter(string -> string.length() == 3).toList();


        System.out.println(result);
        List<String> wordStaringFromT = stringList.stream().filter(string -> string.startsWith("T")).toList();
        System.out.println(wordStaringFromT);

        stringList.stream().filter(string -> string.startsWith("F")).toList().stream().forEach(System.out::println);
        System.out.println("-----------");
        // sorted()
        System.out.println("sorted()");
        stringList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("skip() and limit()");
        result = stringStream.skip(2).limit(2).toList();
        System.out.println(result);

        List<Integer> integerList = Arrays.asList(23, 0,11, 32, 65, 77, 12, 12, 87, 0);
        integerList.stream().sorted().limit(3).forEach(System.out::println);

        System.out.println("distinkt()");
        List<Integer> distinktIntegers = integerList.stream().distinct().sorted().toList();
        System.out.println(distinktIntegers);

        List<Integer> integerResult = integerList.stream().peek(System.out::println).filter(i -> i %2 == 0).toList();
        System.out.println(integerResult);

        List<Integer> lengths = stringList.stream().map(String::length).distinct().sorted().toList();
        System.out.println(lengths);

        List<Employee> employees = Stream.of("Ivan", "John", "Mary", "Jenny").map(name -> new Employee(name, "Surname", 24, 40, true)).toList();
        System.out.println(employees);

    }

}
