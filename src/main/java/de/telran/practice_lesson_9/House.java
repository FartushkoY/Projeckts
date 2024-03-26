package de.telran.practice_lesson_9;

import java.util.Objects;

public class House implements Comparable<House> {
    private int area;
    private int price;
    private String city;
    private boolean hasFurniture;

    public House(int area, int price, String city, boolean hasFurniture) {
        this.area = area;
        this.price = price;
        this.city = city;
        this.hasFurniture = hasFurniture;
    }

    @Override
    public String toString() {
        return "House{" +
                "area=" + area +
                ", price=" + price +
                ", city='" + city + '\'' +
                ", hasFurniture=" + hasFurniture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return area == house.area && price == house.price && hasFurniture == house.hasFurniture && Objects.equals(city, house.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, price, city, hasFurniture);
    }

    @Override
    public int compareTo(House o) {
        int result = Integer.compare(this.price, o.price);
        return result;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public boolean isHasFurniture() {
        return hasFurniture;
    }

    public String getCity() {
        return city;
    }


}
