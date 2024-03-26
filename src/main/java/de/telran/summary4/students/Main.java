package de.telran.summary4.students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 *  Имеется список имен студентов. Написать метод для разбиения списка на
 *     три примерно равные по числу списка в алфавитном порядке.
 */

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(new Student("Anna"),
                new Student("John"),
                new Student("Ted"),
                new Student("Tony"),
                new Student("Ben"),
                new Student("Alex"),
                new Student("Mary"),
                new Student("Sara"),
                new Student("Jerry"),
                new Student("Mandy"),
//                new Student("Bruce"),
                new Student("Miranda"));

        Collections.sort(studentList);
        System.out.println(studentList);
        System.out.println("------------------");
        System.out.println(getThreeLists(studentList));


    }

    private static List<List<Student>> getThreeLists(List<Student> studentList) {

        List<List<Student>> listOfLists = new ArrayList<>();
        int sizeOfLists = (studentList.size() / 3);
        if (studentList.size() - 2 * sizeOfLists >= 2 + sizeOfLists) {
            sizeOfLists ++;
        }
        for (int i = 0; i < studentList.size(); i = i + sizeOfLists) {
            if (listOfLists.size() == 2) {
                sizeOfLists = studentList.size() - i;
                listOfLists.add(makeList(studentList, i, studentList.size() - i));
            } else {
                listOfLists.add(makeList(studentList, i, sizeOfLists));
            }
        }
        return listOfLists;
    }

    private static List<Student> makeList(List<Student> studentList, int startIndex, int sizeOfList) {
        List<Student> newList = new ArrayList<>();
        for (int i = startIndex; i < startIndex + sizeOfList; i++) {
            newList.add(studentList.get(i));
        }
        return newList;
    }
}
