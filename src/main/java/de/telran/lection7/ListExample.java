package de.telran.lection7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = List.of("One", "Two", "Three", "Four", "Five");  // создаст неизменяемый список
        list = Arrays.asList("A", "B", "C", "D");       // список с фиксированной длиной, но элементы изменять можно
        list.set(1, "Two");





    }
}
