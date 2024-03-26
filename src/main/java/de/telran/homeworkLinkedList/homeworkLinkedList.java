package de.telran.homeworkLinkedList;

import java.util.*;

public class homeworkLinkedList {
    public static void main(String[] args) {

        LinkedList<String> strings = new LinkedList<>();
        strings.add("Recognition");
        strings.add("is");
        strings.add("the");
        strings.add("most");
        strings.add("powerful");
        strings.add("motivation");
        strings.add("factor");


//    1. Перебрать LinkedList и найти самую короткую строку.
        Iterator<String> iterator = strings.iterator();
        int minLenght = strings.get(0).length();
        int indexMinElem = 0;
        while (iterator.hasNext()) {
            String current = iterator.next();
            if (current.length() < minLenght) {
                minLenght = current.length();
                indexMinElem = strings.indexOf(current);
            }
        }
        System.out.println(strings.get(indexMinElem));


//       2. Перебрать LinkedList и объединить все строки в одну с использованием разделителя "|".


        // Ниже варианта с for i есть вариант с итератором, но он отработает некорректно, если в тексте будет слово = последнему.
        // Можно ли проверить, является ли элемент последним? я не нашла вариантов,как это сделать

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            if (i == strings.size() - 1) {
                stringBuilder.append(strings.get(i));
            } else {
                stringBuilder.append(strings.get(i)).append("|");
            }
        }
        System.out.println(stringBuilder);


        iterator = strings.iterator();
        StringBuilder stringBuilder2 = new StringBuilder();
        while (iterator.hasNext()) {
            String current = iterator.next();
            if (current.equals(strings.getLast())) {
                stringBuilder2.append(current);
            } else {
                stringBuilder2.append(current).append("|");
            }
        }
        System.out.println(stringBuilder2);


//        3. Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовлетворяющие определенному условию.

        LinkedList<Customer> customers = new LinkedList<>();

        customers.add(new Customer("Jack", "Berlin"));
        customers.add(new Customer("John", "Berlin"));
        customers.add(new Customer("Mary", "Dresden"));
        customers.add(new Customer("Petra", "Jena"));
        customers.add(new Customer("Ted", "Berlin"));
        customers.add(new Customer("Kate", "Frankfurt"));

        Iterator<Customer> iterator1 = customers.iterator();
        String elem = "Berlin";
        while (iterator1.hasNext()) {
            if (iterator1.next().getCity().equals(elem)) {
                iterator1.remove();
            }
        }
        System.out.println(customers);

//        Напишите метод, чтобы получить первое и последнее вхождение указанных элементов в связанном списке.
//    input:
//    list = {1, 4, 3, 2, 1, 2, 2, 0}, element = 2
//    output:
//            3 (индекс первого вхождения), 6 (индекс последнего вхождения)


        LinkedList<Integer> listInt = new LinkedList<>();
        listInt.add(1);
        listInt.add(4);
        listInt.add(3);
        listInt.add(2);
        listInt.add(1);
        listInt.add(2);
        listInt.add(2);
        listInt.add(0);

//  Подозреваю, что этот вариант не пройдет :), потому ниже вариант с написанием метода
        int[] indexes = new int[]{listInt.indexOf(2), listInt.lastIndexOf(2)};
        System.out.println(Arrays.toString(indexes));

        System.out.println(Arrays.toString(getElementsIndex(listInt, 2)));


        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 1, 3, 3, 3, 6, 6, 7, 9));
        System.out.println(Collections.binarySearch(integerList, 3));

        List<String> stringList = new ArrayList<>(Arrays.asList("A", "A", "A", "A", "F", "G", "Y", "Z"));
        System.out.println(binarySearch(stringList, "A"));
        System.out.println("------------------------");
        System.out.println(binarySearchFirst(stringList, "A"));
        System.out.println(binarySearchLast(stringList, "A"));

    }

    public static int binarySearch(List<String> list, String value) {
        int startIndex = 0;

        int endIndex = list.size() - 1;


        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            String current = list.get(middleIndex);
            if (current.compareTo(value) == 0) return middleIndex;
            else if (current.compareTo(value) < 0) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int binarySearchFirst(List<String> list, String value) {
        int startIndex = 0;
        int endIndex = list.size() - 1;


        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            String current = list.get(middleIndex);
            if (current.compareTo(value) == 0) {
                if (middleIndex - 1 >= 0 || current.compareTo(list.get(middleIndex - 1)) > 0)
                return middleIndex;
            else {
                endIndex = middleIndex - 1;
            }
        } else if (current.compareTo(value) < 0) {
            startIndex = middleIndex + 1;
        } else {
            endIndex = middleIndex - 1;
        }
    }
        return-1;
}

    public static int binarySearchLast(List<String> list, String value) {
        int startIndex = 0;
        int endIndex = list.size() - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            String current = list.get(middleIndex);
            if (current.compareTo(value) == 0) {
                if(middleIndex == list.size() - 1 || current.compareTo(list.get(middleIndex + 1)) < 0)
                    return middleIndex;
                else {
                    startIndex = middleIndex + 1;
                }
            } else if (current.compareTo(value) < 0) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int[] getElementsIndex(LinkedList<Integer> list, int element) {
        int[] indexes = new int[2];
        Iterator<Integer> iterator1 = list.iterator();
        int i = 0;
        while (iterator1.hasNext()) {
            Integer current = iterator1.next();
            if (current == element) {
                indexes[0] = i;
                break;
            }
            i++;
        }

        iterator1 = list.descendingIterator();
        int j = list.size() - 1;
        while (iterator1.hasNext()) {
            Integer current = iterator1.next();
            if (current == element) {
                indexes[1] = j;
                break;
            }
            j--;
        }
        return indexes;
    }
}
