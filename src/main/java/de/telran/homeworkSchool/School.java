package de.telran.homeworkSchool;

public class School {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(Subject.ENGLISH);
        Teacher teacher2 = new Teacher(Subject.HISTORY);
        Teacher teacher3 = new Teacher(Subject.MATH);
        Teacher teacher4 = new Teacher(Subject.PHYSICS);
        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");
        Student student3 = new Student("Student3");
        Student student4 = new Student("Student4");

        Student[] students = {student1, student2, student3, student4};

        teacher1.teach(student2);
        teacher2.teach(students);
        System.out.println(student2);
        student3.knows(Subject.HISTORY);

        System.out.println(student2.knows(Subject.HISTORY));
        System.out.println(student2.knows(Subject.MATH));
    }
}
