package de.telran.practice_lesson_9;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        House house1 = new House(150, 150000, "Antalya", false);
        House house7 = new House(100, 120000, "Antalya", true);
        House house2 = new House(120, 120000, "Antalya", false);
        House house3 = new House(80, 180000, "Antalya", true);
        House house4 = new House(100, 180000, "Tübingen", true);
        House house5 = new House(190, 200000, "Stuttgart", false);
        House house6 = new House(60, 80000, "Lviv", true);

        List<House> houseList = new ArrayList<>(Arrays.asList(house1, house2, house3, house4, house5, house6, house7));
        Collections.sort(houseList);
        System.out.println(houseList);
//        TreeSet<House> treeSet = new TreeSet<>(houseList);
//        System.out.println(treeSet);
        System.out.println("------------");
        Collections.sort(houseList, new CompareByCityAndPrice());
        System.out.println(houseList);

        Comparator<House> comparatorByCityAndArea = new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                int result = o1.getCity().compareTo(o2.getCity());
                if (result == 0) result = Integer.compare(o2.getArea(), o1.getArea());
                return result;
            }
        };

        Collections.sort(houseList, comparatorByCityAndArea);
        System.out.println(houseList);

        Collections.sort(houseList, new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                int result = o1.getCity().compareTo(o2.getCity());
                if (result == 0) result = Integer.compare(o1.getPrice(), o2.getPrice());
                if (result == 0) result = Boolean.compare(o2.isHasFurniture(), o1.isHasFurniture());
                return result;
            }
        });
        System.out.println(houseList);


        // Queue
        Queue<House> houseQueue = new LinkedList<>();
        houseQueue.addAll(houseList);
        System.out.println("Queue " + houseQueue);
        System.out.println(houseQueue.remove());
        System.out.println(houseQueue.remove());
        System.out.println(houseQueue);
        houseQueue.add(house3);
        houseQueue.add(house1);
        System.out.println(houseQueue);
        houseQueue.peek();
        System.out.println(houseQueue);


    }
}
