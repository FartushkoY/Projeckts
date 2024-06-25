package de.telran.homework_12_06_Reflection_Annotation;

import java.lang.reflect.Field;
import java.util.Arrays;

public class School {

    @StudentInfo(name = "Tom", surname = "Smith", age = 15)
    private Student student1;
    @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
    private Student student2;


    public static void main(String[] args) {
        School school = new School();


        System.out.println(school.student1);
        System.out.println(school.student2);

        Injector.inject(school);
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
                        Student student = new Student();
                        student.setName(annotation.name());
                        student.setSurname(annotation.surname());
                        student.setAge(annotation.age());
                        try {
                            field.set(instance, student);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
