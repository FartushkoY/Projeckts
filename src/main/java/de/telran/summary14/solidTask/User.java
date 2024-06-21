package de.telran.summary14.solidTask;

import java.util.List;

public class User {

    private String name;
    private  int userId;
    private List<Book> borrowedBooks;

    public User(String name, int userId, List<Book> borrowedBooks) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId=" + userId +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }


    public void returnBook(Book book){
        borrowedBooks.removeIf(b -> b.getIsbn().equals(book.getIsbn()));
    }
}
