package de.telran.summary6;

import de.telran.lection1.house.Cat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {
//        1)
//        public static void feed(List<Cat> catList) {
//            for (int i = 0; i < catList.size(); i++) {
//                if (catList.get(i).isHungry()) {
//                    catList.get(i).setHungry(false);
//                }
//            }
//        }

    List<Cat> catList = Arrays.asList(new Cat("Tom", true),
            new Cat("Vasya", false), new Cat("Murka", false),
            new Cat("Peach", true), new Cat("Symon", true));


//        feed(catList);
//        System.out.println(catList);
        feedWithStream(catList);
        System.out.println(catList);


//        List<Double> doubles = new ArrayList<>();
//        for (Double d : doubleList) {
//            if (d % 2 == 1) {
//                doubles.add(d);
//            }
//        }
//        System.out.println(doubles);
//

        List<Double> doubleList = Arrays.asList(1.0, 5.5, 8.7, 5.2, 7.0);
        List<Double> doubles = new ArrayList<>();
        doubles = doubleList.stream().filter(d -> d % 2 == 1).toList();
        System.out.println(doubles);


//        String word = null;
//        for (String t : list){
//            if (t.length() == 3) {
//                word = t;
//                break;
//            }
//        }
//        System.out.println(word);

        List<String> list = Arrays.asList("Hello", "world", "One", "Six");
        String word = list.stream().filter(string -> string.length() == 3).findFirst().orElse(null);
        System.out.println(word);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(getSumWithStream(integers));
        System.out.println(getSum(integers));

        String[] data = {"Hello", "world", "One", "Six"};
        System.out.println(findIndexWithStream(data, "One"));



        double sum = 0.0;
        for (int i = 0; i < 10_000; i++) {
            sum += 0.1;
        }
        System.out.println(sum);
        System.out.println(IntStream.range(0, 10000).mapToDouble(i -> 0.1).sum());

        System.out.println(integers);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(5);
        integers1.add(5);
        integers1.add(5);
        integers1.add(5);
        integers1.add(5);
//        fill(integers1, 5);
//        System.out.println(integers1);
        fillWithStream(integers1, 5);
        System.out.println(integers1);

    }


    public static class Cat {
        private String name;
        private boolean isHungry;

        public Cat(String name, boolean isHungry) {
            this.name = name;
            this.isHungry = isHungry;
        }

        public void setHungry(boolean hungry) {
            isHungry = hungry;
        }

        public boolean isHungry() {
            return isHungry;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", isHungry=" + isHungry +
                    '}';
        }
    }

    public static void feed(List<Cat> catList) {
            for (int i = 0; i < catList.size(); i++) {
                if (catList.get(i).isHungry()) {
                    catList.get(i).setHungry(false);
                }
            }
        }

    public static void feedWithStream(List<Cat> catList) {
        catList.stream().filter(Cat::isHungry).forEach(cat -> cat.setHungry(false));
    }

    public static int getSum(List<Integer> integers) {
        int oddSum = 0;
        for(Integer i: integers) {
            if(i % 2 != 0) {
                oddSum += i;
            }
        }
        return oddSum;
    }

    public static int getSumWithStream(List<Integer> integers) {
        int oddSum = integers.stream().filter(integer -> integer % 2 != 0).mapToInt(value -> value).sum();
        return oddSum;
    }

    public static int findIndex(String[] data, String element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexWithStream(String[] data, String element) {
        return IntStream.range(0, data.length).filter(j -> data[j].equals(element)).findFirst().orElse(-1);

    }

    public static void fill(List<Integer> list, int capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }

    public static void fillWithStream(List<Integer> list, int capacity) {
        IntStream.range(0, capacity).forEach(list::add);

    }

}
