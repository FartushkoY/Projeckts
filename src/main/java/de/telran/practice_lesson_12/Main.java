package de.telran.practice_lesson_12;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager("Ivan", 1, 10);
        Manager manager2 = new Manager("Andrey", 2, 15);
        Manager manager3 = new Manager("Alex", 3, 7);
        Manager manager4 = new Manager("Anna", 4, 20);

        Sale sale1 = new Sale(1, 5000);
        Sale sale2 = new Sale(2, 2000);
        Sale sale3 = new Sale(3, 1500);
        Sale sale4 = new Sale(1, 3000);
        Sale sale5 = new Sale(4, 4000);
        Sale sale6 = new Sale(4, 5500);

        List<Sale> sales = new ArrayList<>();
        sales.add(sale1);
        sales.add(sale2);
        sales.add(sale3);
        sales.add(sale4);
        sales.add(sale5);
        sales.add(sale6);

        Map<Integer, Manager> managerMap = new HashMap<>();
        managerMap.put(manager1.getId(), manager1);
        managerMap.put(manager2.getId(), manager2);
        managerMap.put(manager3.getId(), manager3);
        managerMap.put(manager4.getId(), manager4);


        Map<Integer, Double> salaryMap = new HashMap<>();
        for (Sale sale : sales) {
            Manager manager = managerMap.get(sale.getIdManager());
            if (!salaryMap.containsKey(sale.getIdManager())) {
                salaryMap.put(sale.getIdManager(), sale.getSumSale().doubleValue() / 100 * manager.getPercent());
            } else {
                Double sum = salaryMap.get(manager.getId());
                salaryMap.put(sale.getIdManager(), sum + sale.getSumSale().doubleValue() / 100 * manager.getPercent());
            }
        }

        System.out.println(salaryMap);
        for (Map.Entry<Integer, Double> elem : salaryMap.entrySet()) {
            Manager manager = managerMap.get(elem.getKey());
            System.out.println(manager.getName() + " заработал " + elem.getValue());
        }

        for (Map.Entry<Integer, Double> elem : salaryMap.entrySet()) {

            System.out.println(elem.getKey() + " - " + elem.getValue());
        }
    }
}
