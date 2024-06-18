package de.telran.homework_12_06_Reflection_Annotation;

import de.telran.lection29.annotation.PeopleInOffice;

import java.lang.reflect.Field;
import java.util.Arrays;

public class School {

    @StudentInfo(name = "Tom", surname = "Smith", age = 15)
    private Student student1;
    @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
    private Student student2;


    public static void main(String[] args) {
        School school = new School();
        Student student = new Student();

        System.out.println(school.student1);
        System.out.println(school.student2);

        Injector.inject(student);
        System.out.println(school.student1);
        System.out.println(school.student2);

    }

    static class Injector {

        public static void inject(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            System.out.println(Arrays.toString(fields));
            for (Field field : fields) {
                if (field.isAnnotationPresent(StudentInfo.class)) {
                    StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                    field.setAccessible(true);
                    try {
                        field.set(instance, annotation.name());
                        field.set(instance, annotation.surname());
                        field.set(instance, annotation.age());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
