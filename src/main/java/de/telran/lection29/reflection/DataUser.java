package de.telran.lection29.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DataUser {

    public static void main(String[] args) {
        Data data = new Data("string data", 10.0);
        System.out.println(data.publicValue);
        data.publicMethod();

        Class<? extends Data> dataClass = data.getClass();
        System.out.println(Arrays.toString(dataClass.getDeclaredMethods()));
        try {
            Method publicMethod = dataClass.getMethod("publicMethod");
            publicMethod.invoke(data);

            Method privateMethod = dataClass.getDeclaredMethod("privateMethod", Double.class);
            privateMethod.setAccessible(true);
            privateMethod.invoke(data, 5.0);

            Field field = dataClass.getDeclaredField("privateValue");
            field.setAccessible(true);
            field.set(data, 25.0);

            System.out.println(data.getPrivateValue());

            Class<?> dataClass2 = Class.forName("lesson20240612.reflection.Data");

            @SuppressWarnings(value = "deprecation")
            Data newInstance1 = (Data) dataClass2.newInstance();
            newInstance1.publicMethod();

            Constructor<?> constructor = dataClass2.getConstructor(String.class, Double.class);
            Data newInstance2 = (Data) constructor.newInstance("string3", 30.0);
            newInstance2.publicMethod();

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException |
                 ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
