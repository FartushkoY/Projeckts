package de.telran.lection12.map;

import java.util.*;

public class Pizza {
    private String name;
    private int size;
    private String cookName;
    private boolean isPresent;

    public Pizza(String name, int size, String cookName, boolean isPresent) {
        this.name = name;
        this.size = size;
        this.cookName = cookName;
        this.isPresent = isPresent;
    }


    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Margarita", 10, "Ivan", true);
        Pizza pizza2 = new Pizza("4 Cheese", 15, "Ivan", false);
        Pizza pizza3 = new Pizza("Diablo", 20, "Ivan", true);
        Pizza pizza4 = new Pizza("Caprichosa", 15, "Ivan", false);
        Pizza pizza5 = new Pizza("Margarita", 10, "James", false);
        Pizza pizza6 = new Pizza("Pepperoni", 20, "James", false);
        List<Pizza> pizzas = Arrays.asList(pizza1, pizza2,pizza3, pizza4, pizza5, pizza6);


        Map<String, Boolean> presenceMap = new HashMap<>();
        for (Pizza pizza : pizzas) {
            if (!presenceMap.containsKey(pizza.name) || !presenceMap.get(pizza.name)) {
                presenceMap.put(pizza.name, pizza.isPresent);
            }
        }
        System.out.println(presenceMap);

        Map<String, Integer> pizzaCountByCook = new HashMap<>();
        for (Pizza pizza : pizzas) {
            String cook = pizza.cookName;
            if (!pizzaCountByCook.containsKey(cook)) {
                pizzaCountByCook.put(cook, 1);
            } else {
                Integer pizzaCount = pizzaCountByCook.get(cook);
                pizzaCountByCook.put(cook, pizzaCount + 1);
            }
        }
        System.out.println(pizzaCountByCook);

        Map<String, Set<String>> pizzaNameByCook = new HashMap<>();
        for (Pizza pizza : pizzas) {
            String cook = pizza.cookName;
            if (pizzaNameByCook.containsKey(cook)) {
                Set<String> pizzaSet = pizzaNameByCook.get(cook);
                pizzaSet.add(pizza.name);
            } else {
                Set<String> pizzaSet = new HashSet<>();
                pizzaSet.add(pizza.name);
                pizzaNameByCook.put(cook, pizzaSet);
            }
        }

        System.out.println(pizzaNameByCook);

        Set<String> ivanPizzas = pizzaNameByCook.get("Ivan");
        Set<String> jamesPizzas = pizzaNameByCook.get("James");
    }


}
