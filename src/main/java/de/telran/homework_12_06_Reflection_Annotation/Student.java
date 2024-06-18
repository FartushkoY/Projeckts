package de.telran.homework_12_06_Reflection_Annotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class Student {

    private String name;
    private String surname;
    private int age;

//    public Student() {
//    }
//
//    public Student(String name, String surname, int age) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    //    public static void main(String[] args) {
//        Student student = new Student();
//
//
//    }



}
