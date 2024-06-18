package de.telran.homework_12_06_Reflection_Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTask {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");


        System.out.println(stringList.size());
        Class<? extends List> listClass = stringList.getClass();
        Field field = listClass.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(stringList);
        System.out.println(elementData.length);
        System.out.println(Arrays.toString(elementData));


//        try {
//            Method publicSize = listClass.getMethod("size");
//            System.out.println(publicSize.invoke(stringList));
////            System.out.println(Arrays.toString(listClass.getDeclaredMethods()));
//
//
//            System.out.println(Arrays.toString(listClass.getDeclaredFields()));
//
//
////
//            field.get(stringList);
            Method grow = listClass.getDeclaredMethod("grow", int.class);
            grow.setAccessible(true);
            grow.invoke(stringList, 12);
        System.out.println(elementData.length);
        System.out.println(Arrays.toString(elementData));
//
//            System.out.println(publicSize);
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }

    }
}
