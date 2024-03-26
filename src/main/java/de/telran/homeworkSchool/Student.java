package de.telran.homeworkSchool;

import java.util.Arrays;

public class Student {
    private String name;
    Subject[] studiedSubjects = new Subject[Subject.values().length];

    public Student(String name){
        this.name = name;
    }

    public Student(String name, Subject... studiedSubjects) {
        this.studiedSubjects = studiedSubjects;
    }


    public boolean knows(Subject subject) {
        return getStudiedSubjects()[subject.ordinal()] == subject;
    }


    @Override
    public String toString() {
        return "Student{" + getName() +
                ". studiedSubjects=" + Arrays.toString(studiedSubjects) +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject[] getStudiedSubjects() {
        return studiedSubjects;
    }

    public void setStudiedSubjects(Subject[] studiedSubjects) {
        this.studiedSubjects = studiedSubjects;
    }
}
