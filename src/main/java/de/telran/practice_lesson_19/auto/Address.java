package de.telran.practice_lesson_19.auto;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    private  int countryCode;
    private  String city;
    private  String street;

    public Address(int countryCode, String city, String street) {
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "countryCode=" + countryCode +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }


}
