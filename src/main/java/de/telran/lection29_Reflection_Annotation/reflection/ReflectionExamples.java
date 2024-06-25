package de.telran.lection29_Reflection_Annotation.reflection;

import java.util.*;

public class ReflectionExamples {

    public static void main(String[] args) {
        String string = "Some string";
        Class<? extends String> stringClass = string.getClass();
        System.out.println(stringClass.getSimpleName());
        System.out.println(stringClass.getName());
        System.out.println(stringClass.getCanonicalName());

        int count = 0;
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass.getSimpleName());
        System.out.println(integerClass.getName());
        System.out.println(integerClass.getCanonicalName());


        int[] ints = {};
        Class<? extends int[]> intsClass = ints.getClass();
        System.out.println(intsClass.getSimpleName());
        System.out.println(intsClass.getName());
        System.out.println(intsClass.getCanonicalName());
        System.out.println(ints);


        Integer[] integers = new Integer[0];
        Class<? extends Integer[]> integersClass = integers.getClass();
        System.out.println(integersClass.getSimpleName());
        System.out.println(integersClass.getName());
        System.out.println(integersClass.getCanonicalName());

        Class<Void> voidClass = void.class;
        System.out.println(voidClass.getSimpleName());
        System.out.println(voidClass.getName());
        System.out.println(voidClass.getCanonicalName());

        List<Double> doubles = new ArrayList<>();
        Class<? extends List> listClass = doubles.getClass();
        System.out.println(listClass.getSimpleName());
        System.out.println(listClass.getName());
        System.out.println(listClass.getCanonicalName());

        List<Double> doubles1 = new Vector<>();
        if (doubles1.getClass() == Vector.class) {
            System.out.println("This link refers to Vector");
        }

        if (doubles1 instanceof Vector<Double>) {
            System.out.println("This link is instanceof Vector");
        }

        doubles = new Stack<>();

        if (doubles1.getClass() == Vector.class) {
            System.out.println("This link refers to Vector");
        }

        if (doubles1 instanceof Vector<Double>) {
            System.out.println("This link is instanceof Vector");
        }

        System.out.println(Arrays.toString(listClass.getConstructors())); // public
        System.out.println(Arrays.toString(listClass.getFields())); // public
        System.out.println(Arrays.toString(listClass.getDeclaredFields())); // public + private
        System.out.println(Arrays.toString(listClass.getMethods())); // public
        System.out.println(Arrays.toString(listClass.getDeclaredMethods())); // public + private


    }
}
