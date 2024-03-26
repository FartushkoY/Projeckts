package de.telran.homeworkSchool;

public class Teacher {
    private Subject subject;

    public Teacher(Subject subject) {
        this.subject = subject;
    }

    public void teach(Student student) {
            student.studiedSubjects[subject.ordinal()] = subject;
            System.out.println(student.getName() + " has studied " + subject);
    }


    public void teach(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            teach(students[i]);
        }
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
