package de.telran.homeworkIterator;

import java.util.*;

public class HwIterator {
    public static void main(String[] args) {
        List names = new ArrayList(Arrays.asList("Mary", "Jane", "Tom", "Tim", "Mark", "Ann", null, "Mark", ""));
//        names.add("Mary");
//        names.add("Jane");
//        names.add("Tom");
//        names.add("Tim");
//        names.add("Mark");
//        names.add("Ann");
//        names.add(null);
//        names.add("");

        System.out.println(names);

//        С помощью итератора:
//        a). Вывести имена, состоящие из 4 букв


        Iterator<String> iterator = names.iterator();


        while (iterator.hasNext()) {
            String elem = iterator.next();
            if (elem != null) {
                if (elem.length() == 4) {
                    System.out.println(elem);
                }
            }
        }
//        while (iterator.hasNext()) {
//            String elem = iterator.next();
//            if (elem == null) {
//                iterator.next();
//            } else {
//                if (elem.length() == 4) {
//                    System.out.println(elem);
//                }
//            }
//        }


//        b). Удалить из списка null и пустые строки.
        iterator = names.iterator();
        while (iterator.hasNext()) {
            String elem = iterator.next();
            if (elem == null) {
                iterator.remove();
            } else if (elem.equals("")) {
                iterator.remove();
            }
        }
        System.out.println(names);


//          С помощью listIterator:
//        c). Удалить из списка все имена, начинающиеся на "T"
        ListIterator<String> listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String elem = listIterator.next();
            if (elem.charAt(0) == 'T') {
                listIterator.remove();
            }
        }
        System.out.println(names);


//        d). Заменить в списке "Ann" на "student Ann"

        listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String elem = listIterator.next();
            if (elem.equals("Ann")) {
                listIterator.set("student Ann");
            }
        }
        System.out.println(names);
    }
}


