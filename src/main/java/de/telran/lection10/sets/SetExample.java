package de.telran.lection10.sets;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
//        Set<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        Set<String> treeSet = new TreeSet<>();
        // sorted set, compareTo()
        // null cannot be added
        // compareTo() must be consistent with equals()
        treeSet.add("E");
        treeSet.add("A");
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("F");
        treeSet.add("D");
        treeSet.add("A");
        System.out.println(treeSet);


        Set<String> hashSet = new HashSet<>();
        //unsorted
        // hashcode(), equals()
        // null can be added
        hashSet.add("Z");
        hashSet.add("K");
        hashSet.add("E");
        hashSet.add("C");
        hashSet.add("B");
        hashSet.add("Y");
        hashSet.add("D");
        hashSet.add(null);
        System.out.println(hashSet);

        Iterator<String> iterator = hashSet.iterator();

        for (String s : hashSet) {
            System.out.println(s);
        }

        hashSet.remove("C");
        System.out.println(hashSet);
        System.out.println(hashSet.contains("K"));
        System.out.println(hashSet.contains("C"));

        SortedSet<String> sortedSet = (SortedSet<String>) treeSet;
        SortedSet<String> subSet = sortedSet.subSet("C", "F");
        System.out.println(subSet);
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());

        NavigableSet<String> navigableSet = (NavigableSet<String>) treeSet;
        NavigableSet<String> descendingSet = navigableSet.descendingSet();
        System.out.println(descendingSet);
    }

}

