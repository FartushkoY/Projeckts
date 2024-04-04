package de.telran.homework_29_03_Map_PriorityDequeue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Shop {


    private static class Product {
        String title;
        int expiration;

        public Product(String title, int expiration) {
            this.title = title;
            this.expiration = expiration;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "title='" + title + '\'' +
                    ", expiration=" + expiration +
                    '}';
        }
    }


    static class Storage {
        Queue<Product> products;
        int count = 0;

        public Storage(Queue<Product> products) {
            this.products = products;
        }

        public void supplyProducts() {
            Random random = new Random();
            for (int i = 1; i < 5; i++) {
                products.add(new Product("Name" + count++, random.nextInt(1,15)));
            }
        }
    }

    static class Customer {
        Queue<Product> products;

        public Customer(Queue<Product> products) {
            this.products = products;
        }

        public void buyProduct() {
           if (!products.isEmpty()) {
            Product product = products.poll();
               System.out.println(this.toString() + " buy " + product);
            }
        }

        @Override
        public String toString() {
            return "Customer";

        }
    }


    public static void main(String[] args) {
        Queue<Product> productQueue = new PriorityQueue<>(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.expiration - o1.expiration;
            }
        });

        Storage storage1 = new Storage(productQueue);
        Storage storage2 = new Storage(productQueue);

        Customer customer1 = new Customer(productQueue);
        Customer customer2 = new Customer(productQueue);
        Customer customer3 = new Customer(productQueue);

        storage1.supplyProducts();
        storage2.supplyProducts();

        customer1.buyProduct();
        customer2.buyProduct();
        customer3.buyProduct();





    }
}
