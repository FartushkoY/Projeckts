package de.telran.lection1.methods;

public class VarArgMethod {

    public static void main(String... args) {
        method("A");
        method("A", "B");
        method("A", "B", "C");

//        System.out.println(args[0]);
//        System.out.println(args[1]);
//        System.out.println(args[2]);
    }

    public static void method(String... strings){
        for (String s : strings) {
            System.out.println(s);
        }
    }

    //    public static void method(String... strings, Integer integer){
    public static void method(Integer integer, String... strings){
        for (String s : strings) {
            System.out.println(s);
        }
    }

//    public static void method(String[] strings){
//        for (String s : strings) {
//            System.out.println(s);
//        }
//    }


}