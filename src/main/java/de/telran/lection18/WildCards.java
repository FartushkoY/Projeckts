package de.telran.lection18;

import java.util.ArrayList;
import java.util.List;

public class WildCards {
    public static void main(String[] args) {

        Box<Integer> box1 = new Box<>(1);
        Box<Double> box2 = new Box<>(1.0);
//        Box<String> box3 = new Box<>("ABC"); // неработает, т к в классе введеы доп.ограничения на тип данных

        List<? extends Number> list1 = new ArrayList<Integer>(); // такой список может содержать только тип Number или его подклассы
        list1 = new ArrayList<Double>();
         list1 = new ArrayList<Number>();

        List<?> list2;
        // аналогичная запись
//        List<? extends Object> list2;

        List<? super Double> list3;


    }

    static class Box <T extends Number> {
        private T t;

        public Box(T t) {
            this.t = t;
        }
    }

}
