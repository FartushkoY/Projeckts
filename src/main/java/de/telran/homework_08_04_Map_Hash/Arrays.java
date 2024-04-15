package de.telran.homework_08_04_Map_Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Arrays {
    public static void main(String[] args) {
        String[] array1 = {"Hello", "!!!", "Hello", "!!!", "!!!", "world", "world", "Hello"};
        String[] array2 = {"Enjoy", "Hello","world", "world", "Hello", "world", "!"};
        String[] array3 = {"world", "Hello","Enjoy",  "!", "Hello", "world", "world"};
        System.out.println(getElemKTimes(array1, 3));
        System.out.println("------------------");
        System.out.println(convertInMap(array1));
        System.out.println(convertInMap(array2));
        System.out.println(compareArrays(array1, array2));
        System.out.println("------------------");
        System.out.println(convertInMap(array2));
        System.out.println(convertInMap(array3));
        System.out.println(compareArrays(array2, array3));

    }


    private static String getElemKTimes(String[] array, int k) {
        Map<String, Integer> countElemMap = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            String elem = array[i];
//            if (!countElemMap.containsKey(elem)) {
//                countElemMap.put(elem, 1);
//            } else {
//                Integer count = countElemMap.get(elem);
//                countElemMap.put(elem, count + 1);
//                if (countElemMap.get(elem) == k) return elem;
//            }
//
//        } return null;
        for (String elem : array) {
            int count = countElemMap.getOrDefault(elem, 0);
            countElemMap.put(elem, count + 1);
            if (countElemMap.get(elem) == k) return elem;
        }
        return null;

    }


    private static boolean compareArrays(String[] arr1, String[] arr2) {
        if (convertInMap(arr1).equals(convertInMap(arr2))) return true;
//        Map<String, Integer> map1 = convertInMap(arr1);
//        Map<String, Integer> map2 = convertInMap(arr2);
//        Set<Map.Entry<String, Integer >> entries = map1.entrySet();
//        for (Map<Map.Entry>)
        else return false;
    }

    private static Map<String, Integer> convertInMap(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String elem = arr[i];
            if (!map.containsKey(elem)) {
                map.put(elem, 1);
            } else {
                Integer counter = map.get(elem);
                map.put(elem, counter + 1);
            }
        } return map;
    }
}

