package de.telran.lection16;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

//        String data = generateData();
//        if (data == null) {
//            data = "Default data";
//        }

        String data = generateData();
        data = (data == null) ? "Default data": data;


        System.out.println(data.toUpperCase());

        System.out.println("some other logic");

        data = generateDataWithOptional().orElse("Default");
        System.out.println(data.toUpperCase());

    }

    public static String generateData() {
        return null;
    }

    public static Optional<String> generateDataWithOptional(){
//        String data = "Data";
//        Optional<String> optional = Optional.of(data);
//        return optional;
        return Optional.empty();
    }

}
