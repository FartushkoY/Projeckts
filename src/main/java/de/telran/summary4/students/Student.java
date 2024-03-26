package de.telran.summary4.students;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student>{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(@NotNull Student o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }
}
