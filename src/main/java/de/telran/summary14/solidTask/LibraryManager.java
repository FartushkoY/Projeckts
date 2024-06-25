package de.telran.summary14.solidTask;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void borrowBook(String isbn, User user){
        Book findBook = library.findBookByIsbn(isbn);
        try  {
            user.borrowBook(findBook);
            findBook.setAvailableCopies(findBook.getAvailableCopies() - 1);
        } catch (NullPointerException e) {
            System.out.println("Книга не найдена");
        }


//        if (findBook != null && findBook.getAvailableCopies() != 0) {
//            user.borrowBook(findBook);
//            findBook.setAvailableCopies(findBook.getAvailableCopies() - 1);
//        } else {
//            System.out.println("Книга не найдена");
//        }

    }


    public void returnBook(String isbn, User user){
        Book returnBook = library.findBookByIsbn(isbn);
        if (returnBook != null) {
            user.returnBook(library.findBookByIsbn(isbn));
            returnBook.setAvailableCopies(returnBook.getAvailableCopies() + 1);
        } else {
            System.out.println("Книга не из нашей библиотеки");
        }
    }


    public void addBook(Book book){
        library.addBook(book);
    }


    public void removeBook(Book book){
        library.removeBook(book);
    }


    public void registerUser(User user){
        library.registerUser(user);
    }


    public static void main(String[] args) {
        Book book1 = new Book("Title1", "Author1", "isbn1", 1);
        Book book2 = new Book("Title2", "Author2", "isbn2", 3);
        Book book3 = new Book("Title3", "Author3", "isbn3", 1);
        Book book4 = new Book("Title4", "Author4", "isbn4", 7);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        User user1 = new User("Name1", 1, new ArrayList<>());
        User user2 = new User("Name2", 2, new ArrayList<>());
        User user3 = new User("Name3", 3, new ArrayList<>());
        User user4 = new User("Name4", 4, new ArrayList<>());
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Library library = new Library(books, users);
        LibraryManager libraryManager = new LibraryManager(library);

        System.out.println(user1);
        System.out.println(book1);
        libraryManager.borrowBook("isbn1", user1);
        libraryManager.borrowBook("isbn2", user1);
        libraryManager.borrowBook("isbn5", user2);
        libraryManager.borrowBook("isbn1", user2);
        System.out.println(user1);
        System.out.println(book1);

        libraryManager.returnBook("isbn1", user1);
        libraryManager.returnBook("isbn5", user1);
        System.out.println(user1);
        System.out.println(book1);

    }
}
