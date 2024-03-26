package de.telran.lection9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookShop {

    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter1", "Rawling", 20.0, 10,true);
        Book book2 = new Book("Harry Potter2", "Rawling", 15.0, 12, true);
        Book book3 = new Book("War and Peace", "Tolstoy", 50.0, 0,false);
        Book book4 = new Book("Crime and Punishment", "Dostoewsky", 25.0, 20,true);
        Book book5 = new Book("Tom Sawyer", "Mark Twain", 100.0, 15,true);
        Book book6 = new Book("Harry Potter3", "Rawling", 15.0, 10,true);
        Book book7 = new Book("Harry Potter4", "Rawling", 15.0, 1,true);
        List<Book> bookList = Arrays.asList(book1, book2, book3, book4, book5, book6, book7);

        Collections.sort(bookList, new Book.BookByAuthorComparator());

        System.out.println("Books in shop by Author");
        for (Book book : bookList) {
            System.out.println(book);
        }

        Collections.sort(bookList, new Book.BookByPriceComparator());
        System.out.println("Books in shop by price");
        for (Book book : bookList) {
            System.out.println(book);
        }

        System.out.println("Books in shop by count");
        Collections.sort(bookList, new Book.BookByPriceComparator());
        System.out.println("Books in shop by price");
        for (Book book : bookList) {
            System.out.println(book);
        }


        System.out.println("Books in shop by price from max to min");
        Collections.sort(bookList, new Book.BookByPriceComparator().reversed());
        for (Book book : bookList) {
            System.out.println(book);
        }

        // sort by autor, price
        System.out.println("Books in shop by author, pryce");

        Collections.sort(bookList, new Book.BookByPriceComparator());
        Collections.sort(bookList, new Book.BookByAuthorComparator());
        for (Book book : bookList) {
            System.out.println(book);
        }

        System.out.println("Books inshop by author, pryce with anonymus comparator");
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                int result = book1.getAutor().compareTo(book2.getAutor());
                if (result == 0) {
                    result = Double.compare(book1.getPrice(), book2.getPrice());
                }
                return result;
            }
        });

        for (Book book : bookList) {
            System.out.println(book);
        }



    }




}
