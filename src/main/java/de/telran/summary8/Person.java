package de.telran.summary8;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private String name;
    private String sername;
    private int age;
    private Address address;

    public Person(String name, String sername, int age, Address address) {
        this.name = name;
        this.sername = sername;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sername='" + sername + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(sername, person.sername) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sername, age, address);
    }

    public Address getAddress() {
        return address;
    }
}
