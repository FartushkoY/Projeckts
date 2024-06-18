package de.telran.practice_lesson_28;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@BadCode(name = "Yevgeniia", comment = "Некорректный класс")
public class Student {
    private String name;
    private  String group;

    @BadCode(name = "Yevgeniia", comment = "Некорректный формат")
    private int age;

    public Student(String name, String group, int age) {
        this.name = name;
        this.group = group;
        this.age = age;
    }

    public void introduction() {
        System.out.println("My name is " + name + ". My group is " + group + ". I am " + age);
    }

    @BadCode(name = "Yevgeniia", comment = "Некорректное условие")
    private boolean isDrinking() {
        return age >= 21;
    }

    @BadCode(name = "Yevgeniia", comment = "Дискриминация по возрасту")
    void party(){
        System.out.println(isDrinking() ? "Можно ли наливать алкоголь" : "Нельзя наливать алкоголь");
    }


    public static void main(String[] args) {
        Student student1 = new Student("Vasya", "21_11", 19);
        Class<?> studentClass = student1.getClass();
        if (studentClass.isAnnotationPresent(BadCode.class)) {
            System.out.print(studentClass.getSimpleName() + "; ");
            BadCode badCode = studentClass.getAnnotation(BadCode.class);
            System.out.println(badCode.name() + "; " + badCode.comment());
        }

        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(BadCode.class)) {
                System.out.print(field.getName() + "; ");
                BadCode badCode = field.getAnnotation(BadCode.class);
                System.out.println(badCode.name() + "; " + badCode.comment());
            }
        }

        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(BadCode.class)) {
                System.out.print(method.getName() + "; ");
                BadCode badCode = method.getAnnotation(BadCode.class);
                System.out.println(badCode.name() + "; " + badCode.comment());
            }

        }
    }


}
