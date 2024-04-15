package de.telran.summary5;

import java.util.*;

public class CollectionExamples {
    public static void main(String[] args) {
        Set<String> set = Collections.emptySet();
        System.out.println(set);


        Collection<Integer> list = new ArrayList<>();

        List<Integer> emptyList = Collections.emptyList();
        List<Integer> newList = new LinkedList<>();
        Collections.copy(emptyList, newList);

        Collections.singletonList("Element");



    }

}
