package de.telran.lection10;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CompareExamples {
    public static void main(String[] args) {


        Object o1 = "123";
        Object o2 = "123";

        String s1 = (String) o1;
        String s2 = (String) o1;
        System.out.println(s1.compareTo(s2));   // Если один из объектов = null, то будет налл поинтер эксепшен, т к попытка сравнения несуществующено объекта

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));      //true, false
        System.out.println(s1.compareTo(s2));   //0, not 0

        // equals() consistent with compareTo()
        // s1.equals(s2) == true ------> s1.compareTo(s2)
        //s1.compareTo(s2) == true ------> s1.equals(s2)

        Item item1 = new Item(1, "item");
        Item item2 = new Item(2, "item");
        System.out.println(item1.compareTo(item2));
        System.out.println(item1.equals(item2));

        Object object1 = "123";
        Object object2 = 123;


    }

    static class Item implements Comparable<Item> {
        int id;
        String name;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(@NotNull CompareExamples.Item o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }




}
