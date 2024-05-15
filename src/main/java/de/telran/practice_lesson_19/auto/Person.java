package de.telran.practice_lesson_19.auto;



import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private  String firstName;
    private  String lastName;
    private  Address address;

    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

}
