package de.telran.lection13;
import java.util.*;

public class SetVsMap {


    public static void main(String[] args) {
        // Map Set
        // TreeMap ---> TreeSet
        // HashMap ---> HashSet

        Set<String> strings = new TreeSet<>();
        strings.add("One");

//        Map<String, Object> stringObjectMap = new TreeMap<>();
//        stringObjectMap.put("One", new Object());

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("C", 1);
        map.put("B", 1);
        map.put("A", 1);
        System.out.println(map);
    }


}