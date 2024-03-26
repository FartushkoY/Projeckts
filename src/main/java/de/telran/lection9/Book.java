package de.telran.lection9;

import java.util.Comparator;

public class Book {

    private String title;
    private String autor;
    private double price;
    private int bookCount;
    private boolean isInStock;


    public Book(String title, String autor, double price, int bookCount, boolean isInStock) {
        this.title = title;
        this.autor = autor;
        this.price = price;
        this.bookCount = bookCount;
        this.isInStock = isInStock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", price=" + price +
                ", bookCount=" + bookCount +
                ", isInStock=" + isInStock +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public double getPrice() {
        return price;
    }

    public int getBookCount() {
        return bookCount;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public static class BookByAuthorComparator implements Comparator<Book> {

        @Override
        public int compare(Book book1, Book book2) {

            return book1.autor.compareTo(book2.autor);
        }
    }

    public static class BookByPriceComparator implements Comparator<Book> {

        @Override
        public int compare(Book book1, Book book2) {
            double price1 = book1.price;
            double price2 = book2.price;

//            return (price1 < price2 ? -1 : (price1 > price2 ? 1: 0));

            return Double.compare(price1, price2);  // использован уже реализованный compare для класса-обертки Double
        }


        public static class BookByCountComparator implements Comparator<Book> {

            @Override
            public int compare(Book book1, Book book2) {
                int count1 = book1.bookCount;
                int count2 = book2.bookCount;

                return (Integer.compare(count1, count2));
//                return (count1 < count2 & -1 : (count1 == count2 ? 0 : 1));   можно так и так, но на практике чем меньше самописного кода, тем лучше
//                return count1 - count2;           если есть уже реализованные методы, всегда лучше использовать их
            }
        }

    }


}
