package de.telran.lection18;

import de.telran.homeworkComparator.Employee;

import java.util.ArrayList;
import java.util.List;

public class GenericExamples {
    public static void main(String[] args) {

        Object o;

        o = "String";
//        o = 2;
//        System.out.println(((String) o).toUpperCase());

        List list = new ArrayList<>();

        List<String> stringList = new ArrayList<>(); //в последних <> неявно указан тип списка, какой и при его объявлении
        new ArrayList<>().add("123");


        GenericClass<Integer, Object> genericClass1 = new GenericClass<>(123);
        genericClass1.process("input1");

        GenericClass<String, Employee> genericClass2 = new GenericClass<>("string data");
        genericClass2.process("input2");

        System.out.println(genericClass1.function(10));

        System.out.println(genericClass2.function("string value"));

        Object object = genericClass1.methodWithM(new Object());
        Employee employee = genericClass2.methodWithM(new Employee("John", "Smith", 32, 176, false, "IT"));

        staticGenericMethod(123);
        staticGenericMethod("string");

        // o1, o2 ---> list of o1, o2
        List<Integer> integerList = makeListFromTwoElements(1,2);
        System.out.println(integerList);
        List<String> strings = makeListFromTwoElements("A", "B");
        System.out.println(strings);
    }

    public static <T> void staticGenericMethod(T t1) {
        T t2 = null;
        System.out.println(t1);
        System.out.println(t2);
    }

    public static <T> List<T> makeListFromTwoElements(T t1, T t2) {
//        List<T> list = new ArrayList<>();
//        list.add(t1);
//        list.add(t2);
//        return list;

        return List.of(t1, t2);
    }

}
