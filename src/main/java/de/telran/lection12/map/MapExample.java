package de.telran.lection12.map;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {
//        Map<String, Integer> map = new TreeMap<>(); // требования на ключи  compareTo(), Comparator
        Map<String, Integer> map = new HashMap<>(); // требования на ключи  equals(), hashCode()
        map.put("A", 5);
        map.put("B", 50);
        map.put("C", 10);
        map.put("D", 10);
        map.put("E", 70);

        // put(), get(), containsKey()  ----> O(log n)
        System.out.println(map.get("C"));
        System.out.println(map.get("E"));

        System.out.println(map.get("A"));
        map.put("A", 70);
        System.out.println(map.get("A"));

        System.out.println(map.containsKey("D"));

        System.out.println(map.containsValue(50));

        // keys
        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        // values
        Collection<Integer> values = map.values();
        System.out.println(values);

        // keys + values
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("entry key: " + entry.getKey() + ", entry value: " + entry.getValue());
        }




    }
}
