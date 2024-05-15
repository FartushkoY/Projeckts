package de.telran.summary8;

import java.io.*;
import java.util.Arrays;

public class SerialisationExample {
    public static void main(String[] args) {
        Address address1 = new Address("USA", "NY");
        Address address2 = new Address("Germany", "Berlin");
        Person person1 = new Person("John", "Smith", 23, address1);
        Person person2 = new Person("Jane", "Small", 32, address2);
        // serialization
        byte[] outByteArray = null;
        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream outputStream = new ObjectOutputStream(out);
        ) {
            outputStream.writeObject(person1);
            outputStream.writeObject(person2);
            outByteArray = out.toByteArray();
            System.out.println(Arrays.toString(outByteArray));
        } catch (IOException e) {
            e.printStackTrace();
        }




        // deserialization
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(outByteArray);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
        ) {
            Person deserializedPerson = (Person) objectInputStream.readObject();
            Person deserializedPerson2 = (Person) objectInputStream.readObject();
            System.out.println(deserializedPerson);
            System.out.println(deserializedPerson2);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
