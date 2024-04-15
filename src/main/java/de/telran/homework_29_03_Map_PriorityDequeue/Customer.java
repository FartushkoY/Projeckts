package de.telran.homework_29_03_Map_PriorityDequeue;

import java.util.*;

public class Customer implements Comparable<Customer>{
    private String name;
    private String email;
    private String country;
    private int bonusAmount;
    private boolean isEmailConfirmed;

    public Customer(String name, String email, String country, int bonusAmount, boolean isEmailConfirmed) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.bonusAmount = bonusAmount;
        this.isEmailConfirmed = isEmailConfirmed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return bonusAmount == customer.bonusAmount && isEmailConfirmed == customer.isEmailConfirmed
                && Objects.equals(name, customer.name) && Objects.equals(email, customer.email)
                && Objects.equals(country, customer.country);
    }


    @Override
    public int hashCode() {
        return ((name == null ? 0 : name.hashCode()) + (email == null ? 0 : email.hashCode() * 31) +
                (country == null ? 0 : country.hashCode() * 31 * 31) + (bonusAmount * 31 * 31 * 31) + Boolean.hashCode(isEmailConfirmed));
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", bonusAmount=" + bonusAmount +
                ", isEmailConfirmed=" + isEmailConfirmed +
                '}';
    }


    @Override
    public int compareTo(Customer o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = this.email.compareTo(o.email);
        }
        if (result == 0) {
            result = this.country.compareTo(o.country);
        }
        if (result == 0) {
            result = Integer.compare(this.bonusAmount, o.bonusAmount);
        }
        if (result == 0) {
            result = Boolean.compare(this.isEmailConfirmed, o.isEmailConfirmed);
        }
        return result;
    }



    public static void main(String[] args) {
        Customer customer1 = new Customer("Mariia", "123@gmail.com", "Ukraine", 100, true);
        Customer customer2 = new Customer("Ted", "ted@gmail.com", "USA", 0, false);
        Customer customer3 = new Customer("Sara", "sara@gmail.com", "Germany", 150, true);
        Customer customer4 = new Customer("Valeria", "valeria@gmail.com", "Germany", 70, true);
        Customer customer5 = new Customer("John", "john@gmail.com", "USA", 200, true);
        Customer customer6 = new Customer("Andriy", "1andriy@gmail.com", "Ukraine", 10, false);
        List<Customer> list = Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6);

        Map<String, String> mapEmailCountry = new HashMap<>();
        for (Customer customer : list) {
            mapEmailCountry.put(customer.email, customer.country);
        }
        System.out.println(mapEmailCountry);

        Map<String, String> mapEmailName = new TreeMap<>();
        for (Customer customer : list) {
            mapEmailName.put(customer.email, customer.name);
        }
        System.out.println(mapEmailName);

        Map<Boolean, Integer> customersCountByConfirmedEmail = new HashMap<>();
        for (Customer customer : list) {
            boolean isConfirm = customer.isEmailConfirmed;
            if (!customersCountByConfirmedEmail.containsKey(isConfirm)) {
                customersCountByConfirmedEmail.put(isConfirm, 1);
            } else {
                Integer emailCounter = customersCountByConfirmedEmail.get(isConfirm);
                customersCountByConfirmedEmail.put(isConfirm, emailCounter + 1);
            }
        }
        System.out.println(customersCountByConfirmedEmail);

        Map<String, List<Customer>> customersFromCountries = new TreeMap<>();
        for (Customer customer : list) {
            List<Customer> customerList = customersFromCountries.getOrDefault(customer.country, new ArrayList<>());
            customerList.add(customer);
            customersFromCountries.put(customer.country, customerList);
//            String country = customer.country;
//            if (customersFromCountries.containsKey(country)) {
//                List<String> customersList = customersFromCountries.get(country);
//                customersList.add(customer.name);
//            } else {
//                List<String> customersList = new ArrayList<>();
//                customersList.add(customer.name);
//                customersFromCountries.put(country, customersList);
//            }
        }
        System.out.println(customersFromCountries);

        System.out.println("----------------");

        Map<String, Integer> totalBonusFromCountry = new TreeMap<>();
        for (Customer customer : list) {
            String country = customer.country;
            if (!totalBonusFromCountry.containsKey(country)) {
                totalBonusFromCountry.put(country, customer.bonusAmount);
            } else {
                Integer bonusCounter = totalBonusFromCountry.get(country);
                totalBonusFromCountry.put(country, bonusCounter + customer.bonusAmount);
            }
        }
        System.out.println(totalBonusFromCountry);

        Map<Customer, Integer> testHashMap = new HashMap<>();
        testHashMap.put(customer1, 1);
        testHashMap.put(customer2, 2);
        testHashMap.put(customer3, 3);
        testHashMap.put(customer4, 4);
        testHashMap.put(customer5, 5);
        testHashMap.put(customer6, 6);
        System.out.println("Print HashMap");
        System.out.println(testHashMap);

        Map<Customer, Integer> testTreeMap = new TreeMap<>();
        testTreeMap.put(customer1, 1);
        testTreeMap.put(customer2, 2);
        testTreeMap.put(customer3, 3);
        testTreeMap.put(customer4, 4);
        testTreeMap.put(customer5, 5);
        testTreeMap.put(customer6, 6);
        System.out.println("Print TreeMap");
        System.out.println(testTreeMap);
    }
}
