package de.telran.lection2;

public class CastExamples {

    public static void main(String[] args) {


        Object o = 10;
        Number n = 10;

        Object object = "String";
        object = new Child();
        object = "String value";
        object = 10.0;

        Double newLink = (Double) object; // cast
        System.out.println(newLink);


        int intValue = 10;
        Integer integer = 20;
        System.out.println(((int)integer) + intValue); // unboxing
        integer = (Integer) intValue; // boxing

        Parent parent = new Parent();
        Child child = new Child();

        parent = child; // save
        child = (Child) parent; // unsave

    }


}
