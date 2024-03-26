package de.telran.summary1;

public class EqualsForStrings {

    public static void main(String[] args) {
        String string1 = "string";
        String string2 = "string";
        String string3 = new String("string");

        System.out.println(string1 == string2);
        System.out.println(string1.equals(string2));

        System.out.println(string1 == string3);
        System.out.println(string1.equals(string3));

        string3 = string3.intern();

        System.out.println(string1 == string3);
        System.out.println(string1.equals(string3));

        Integer integer1 = 127;  // Integer pool for integers -128 ... 127
        Integer integer2 = 127;
        System.out.println(integer1 == integer2);
        System.out.println(integer1.equals(integer2));

    }


}
