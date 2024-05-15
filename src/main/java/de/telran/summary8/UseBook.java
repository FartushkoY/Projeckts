package de.telran.summary8;

import de.telran.homework_10_05_Input_Output.Book;

import java.io.*;
import java.util.Arrays;

public class UseBook {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "Joanne Rowling", 25.00, 100);
        Book book2 = new Book("Gone with the wind", "Margareth Mitchell", 15.00, 50);
        Book book3 = new Book("Matador", "Luis Rivera", 7.50, 20);
        Book book4 = new Book("The Hobbit", "J.R.R. Tolkien", 35.00, 150);
        Book book5 = new Book("Charlie and the Chocolate Factory", "Roald Dahl", 10.50, 60);

        Book[] books = {book1, book2, book3, book4, book5};
        File file = new File("D:/Study_Telran/Projeckts/JavaPro3/resources/books.txt");

        byte[] outByteArray = null;


        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream outputStream = new ObjectOutputStream(out);
                Writer writer = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

        ) {
            outputStream.writeObject(book1);
            outputStream.writeObject(book2);
            outputStream.writeObject(book3);
            outputStream.writeObject(book4);
            outputStream.writeObject(book5);
            outByteArray = out.toByteArray();
            bufferedWriter.write(Arrays.toString(outByteArray));
//            System.out.println(Arrays.toString(outByteArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytesNew = new byte[(int) file.length()];

        try (
                FileInputStream inputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Reader reader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {

            for (int i = 0; i < books.length; i++) {
                Book bookNew = (Book) objectInputStream.readObject();
                System.out.println(bookNew);
            }

//            bytesNew = Files.readAllBytes(Paths.get());         ;
//            bytesNew = bufferedReader.toString().getBytes(StandardCharsets.UTF_8);
            System.out.println(Arrays.toString(bytesNew));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try (
//
//
//                ByteArrayInputStream inputStream = new ByteArrayInputStream(bytesNew);
//                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//
//
//        ) {
//            for (int i = 0; i < books.length; i++) {
//                Book deserializationbook = (Book) objectInputStream.readObject();
//                System.out.println(deserializationbook);
//            }
//
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
