package de.telran.lection8;

import java.util.LinkedList;
import java.util.List;

public class School {
    public static void main(String[] args) {
        //        Составить список студентов, распределенных по отдельным классам List<List<Student>> studentGrades
//                - Написать метод countTotalAmount(studentGrades), который считает общее число студентов
//        - Написать метод countAmountWithName(studentGrades, name), который считает количество студентов в школе с заданным именем name.


        List<List<Student>> listsOfStudent = new LinkedList<>();
        Student student1 = new Student("John", 19);
        Student student2 = new Student("Myke", 20);
        Student student3 = new Student("Jane", 18);
        Student student4 = new Student("Ann", 19);
        Student student5 = new Student("John", 19);
        Student student6 = new Student("Sophy", 21);
        Student student7 = new Student("Ted", 20);
        listsOfStudent.add(List.of(student1, student2, student3, student4));
        listsOfStudent.add(List.of(student5, student6, student7));
        System.out.println(listsOfStudent);
        System.out.println(countTotalAmount(listsOfStudent));
        System.out.println(countAmountWithName(listsOfStudent, "John"));


    }

    public static int countTotalAmount(List<List<Student>> studentGrades) {
        int counter = 0;
        for (List<Student> students : studentGrades) {
            counter += students.size();
        }
    return counter;
    }


    public static int countAmountWithName(List<List<Student>> studentGrades, String name) {
        int counter = 0;
        for (List<Student> listsOfStudents : studentGrades) {
            for (Student student : listsOfStudents) {
                if (student.getName().equals(name)){
                    counter++;
                }
            }
        } return counter;
    }

}
