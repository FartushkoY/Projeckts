package de.telran.summary4.students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainTest {
    //    Имеется список имен студентов. Написать метод для разбиения списка на
//    три примерно равные по числу списка в алфавитном порядке.
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
                new Student("Bruce"),
                new Student("Miranda"));

        Collections.sort(studentList);
        System.out.println(studentList);


        System.out.println(studentList.size() / 3);
        System.out.println(getThreeLists(studentList));
        List<List<Student>> listOfLists = new ArrayList<>();
        listOfLists = getThreeLists(studentList);
        System.out.println(listOfLists);


    }

    private static List<List<Student>> getThreeLists(List<Student> list) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        List<List<Student>> listOfLists = Arrays.asList(list1, list2, list3);
        int currentIndex = (list.size() - 1) / 3;
        int startIndex = 0;
//        for (int i = 0; i < 1; i++) {
//            int currentLeftIndex = getSplitPointLeft(list, startIndex, currentIndex);
//            int currentRightIndex = getSplitPointRight(list, currentIndex);
//            if (currentIndex - currentLeftIndex < currentRightIndex - currentIndex) {
//                listOfLists.add(getCompletedList(list, startIndex, currentLeftIndex - 1));
//                startIndex = currentLeftIndex;
//            } else {
//                listOfLists.add(getCompletedList(list, startIndex, currentRightIndex));
//                startIndex = currentRightIndex + 1;
//            }
//            currentIndex = currentIndex * 2;
//        }
//        getCompletedList(list, (currentIndex + 1), (list.size() - 1));




        return listOfLists;
    }

    private static List<Student> getCompletedList(List<Student> list, int firstIndex, int lastIndex) {
        List<Student> newList = new ArrayList<>();
        for (int i = firstIndex; i <= lastIndex; i++) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public static int getSplitPointLeft(List<Student> list, int startIndex, int currentIndex) {
        char current = list.get(currentIndex).getName().charAt(0);
        while (startIndex <= currentIndex) {

            int middleIndex = startIndex + (currentIndex - startIndex) /2;
            if (current == list.get(middleIndex).getName().charAt(0)) {
                if (middleIndex == 0 || current > list.get(middleIndex-1).getName().charAt(0)) {
                    return middleIndex;
                } else {
                    currentIndex = middleIndex -1;
                }
            }
        } return currentIndex;
    }

    private static int getSplitPointRight (List<Student> list, int currentIndex) {
        char current = list.get(currentIndex).getName().charAt(0);
        int endIndex = list.size() - 1;
        while (currentIndex < endIndex) {

            int middleIndex = currentIndex + (endIndex - currentIndex) /2;
            if (current == list.get(middleIndex).getName().charAt(0)) {
                if (middleIndex == list.size() - 1 || current < list.get(middleIndex+1).getName().charAt(0)) {
                    return middleIndex;
                } else {
                    endIndex = middleIndex -1;
                }
            }
        } return currentIndex;
    }




}
