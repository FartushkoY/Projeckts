package de.telran.summary8;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
    private String countryy;
    private String city;

    public Address(String countryy, String city) {
        this.countryy = countryy;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "countryy='" + countryy + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(countryy, address.countryy) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryy, city);
    }




}
