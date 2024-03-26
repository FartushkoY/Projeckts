package de.telran.lection3;

public class CheckClassExample {


    public static void main(String[] args) {
        Number object = 1.0;

        System.out.println(object.getClass());
        System.out.println(object.getClass() == Number.class);
        System.out.println(object instanceof Number);

    }

}
