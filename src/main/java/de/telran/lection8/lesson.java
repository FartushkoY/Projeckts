package de.telran.lection8;

import java.util.LinkedList;
import java.util.List;

public class lesson {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.addFirst(1);
        linkedList.addLast(10);
        linkedList.add(2, 8);
        System.out.println(linkedList);

        for (int i = 0; i < linkedList.size(); i++) {       //будет работать медленно со связанным списком, т к чтобы найти каждый элемент по индексуб
            System.out.println(linkedList.get(i));          // нужно будет каждый раз пройти весь список с начала до элемента с искомым индексом
        }

        for (Integer integer : linkedList) {            // будет работать значительно быстрее
            System.out.println(integer);
        }
//  верхняя и нижняя записи аналогичны, в for each неявно вызывается итератор

//        Iterator<Integer> iterator = linkedList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }


        List<List<Double>> listOfLists = new LinkedList<>();
        listOfLists.add(List.of(1.0, 2.0, 3.0));
        listOfLists.add(List.of(4.0, 5.0, 6.0));
        listOfLists.add(List.of(7.0, 8.0, 9.0));

        System.out.println(listOfLists.get(1).get(2));

        for (List<Double> doubles : listOfLists) {
            for (Double d : doubles) {
                System.out.println(d);
            }
        }

//        Составить список студентов, распределенных по отдельным классам List<List<Student>> studentGrades
//                - Написать метод countTotalAmount(studentGrades), который считает общее число студентов
//        - Написать метод countAmountWithName(studentGrades, name), который считает количество студентов в школе с заданным именем name.



//        Дан список некоторых упорядоченных данных. Необходимо "честно" перемешать данные,
//        т.е. распределить их так, чтобы вероятность нахождения любого элемента на любом месте была бы одинакова.
//        Например, задача перемешивания колоды карт.








    }
}
