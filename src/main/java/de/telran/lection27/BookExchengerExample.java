package de.telran.lection27;

import javax.sql.rowset.serial.SerialStruct;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BookExchengerExample {

    static class BookFan implements Runnable{

        String book;

        Exchanger<String> exchanger = new Exchanger<>();
        public BookFan(String book, Exchanger exchanger) {
            this.book = book;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() + " is reading " + book);
                Thread.sleep(5000 + new Random().nextInt(5000));
                String bookFromOtherPerson = exchanger.exchange(book, 20, TimeUnit.SECONDS);

                System.out.println(Thread.currentThread().getName() + " is reading " + bookFromOtherPerson);
                Thread.sleep(5000 + new Random().nextInt(5000));

            } catch (InterruptedException | TimeoutException e) {
                System.out.println(Thread.currentThread().getName() + " went for a wwalk");


        }
    }


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        BookFan bookFan1 = new BookFan("Harry Potter", exchanger);
        BookFan bookFan2 = new BookFan("Java in Action", exchanger);
        BookFan bookFan3 = new BookFan("Intro to Algorithms", exchanger);

        new Thread(bookFan1, "Steve").start();
        new Thread(bookFan2, "Ken").start();
        new Thread(bookFan3, "Jane").start();

    }

}}
