package de.telran.homework_12_06_Reflection_Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTask {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Class<? extends List> listClass = list.getClass();
        Field field = listClass.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println(elementData.length);
        System.out.println(Arrays.toString(elementData));

        try {
            Method grow = listClass.getDeclaredMethod("grow", int.class);
            grow.setAccessible(true);
            grow.invoke(list, 60);
            elementData = (Object[]) field.get(list);
            System.out.println(elementData.length);
            System.out.println(Arrays.toString(elementData));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
