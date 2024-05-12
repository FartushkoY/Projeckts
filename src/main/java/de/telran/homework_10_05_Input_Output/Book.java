package de.telran.homework_10_05_Input_Output;

import java.io.*;
import java.util.Objects;

public class Book implements Serializable {

    private String title;
    private String author;
    private double price;
    private int bookCount;


    public Book(String title, String author, double price, int bookCount) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", bookCount=" + bookCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && bookCount == book.bookCount && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, bookCount);
    }


    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "Joanne Rowling", 25.00, 100);
        Book book2 = new Book("Gone with the wind", "Margareth Mitchell", 15.00, 50);
        Book book3 = new Book("Matador", "Luis Rivera", 7.50, 20);
        Book book4 = new Book("The Hobbit", "J.R.R. Tolkien", 35.00, 150);
        Book book5 = new Book("Charlie and the Chocolate Factory", "Roald Dahl", 10.50, 60);
        Book[] books = {book1, book2, book3, book4, book5};

        File file = new File("D:/Study_Telran/Projeckts/JavaPro3/resources/books.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (
                FileOutputStream out = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(out);
        ) {
            for (int i = 0; i < books.length; i++) {
                outputStream.writeObject(books[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            for (int i = 0; i < books.length; i++) {
                Book deserializedBook = (Book) objectInputStream.readObject();
                System.out.println(deserializedBook);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}