package de.telran.summary7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PECSExample {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("A", "B", "C");
        List<Object> objectList = List.of(1, "Hello", 1.0);


        List<Object> objects = objectList;
//        objects = stringList;
        List<?> otherList = stringList;



        List<Tesla> teslas = List.of(new Tesla(), new Tesla());
        List<Car> cars = List.of(new BMW(), new Tesla(), new Mersedes());
        List<TeslaNodification> teslaModifications = List.of(new TeslaNodification());

        List<? extends Car> list; // в такой список невозможно добавлять элементы (add()), он может быть только Producer Extends
        list = cars;
        list = teslas;
        Car tesla = list.get(0);
//        list.add(new Tesla());
//        list.add(new Car());


        List<? super TeslaNodification> list2; //  такой список может быть только Consumer super (только накапливать обїекты)
        list2 = cars;
        list2 = teslas;
        list2 = teslaModifications;
//        list2 = new ArrayList<BMW>();
        Object el1 = list2.get(0); // возможно достать только в тип Object. это можно, но бесполезно
        list2.add(new TeslaNodification());
//        list2.add(new Tesla());  // т к неизвестно, каким именно типом будет параметризован список
//        list2.add(new Car());

        method(list);

    }

    private static void method(List<? extends Car> list) { // list as producer
        Car car = list.get(0);
        // do something with car
//        list.add(new Car());  // невозможно
    }

    private static void method2(List<? super Car> list) { // list as concumer
//        Car car = list.get(0);  // невозможно
        list.add(new Car());
    }
}
