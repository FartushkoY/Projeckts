package de.telran.summary14.solidTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Book> books;
    private List<User> users;

    public Library(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
    }

    public void addBook(Book book) {
         books.add(book);
    }
    public void removeBook(Book book){
        books.removeIf(b -> b.getIsbn().equals(book.getIsbn()));
    }
    public void registerUser(User user){
        users.add(user);
    }
    public Book findBookByIsbn(String isbn){
        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
    }




}
