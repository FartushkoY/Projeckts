package de.telran.lection5;

public class Cat implements Cloneable {

    private String name;
    private String colour;
    private  int age;

    public Cat(String name, String colour, int age) {
        this.name = name;
        this.colour = colour;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Cat clone() throws CloneNotSupportedException {
        return (Cat) super.clone();
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Tom", "white", 3);
        System.out.println(cat);
        try {
            Cat clonedCat = (Cat) cat.clone();
            System.out.println(clonedCat);
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
        }
    }
}
