package de.telran.lection1.methods;

public class TestMethods {

    public static void main(String[] args) {
        int result = method();
        method("sting");
        method("string", 1);
        method(new String[] {"A", "B"});
    }


    public static String method(String s) {
        return "string";
    }

    public static String method(String s, Integer i) {
        return "string";
    }

    public static String method(String[] s) {
        return "string";
    }

    public static int method() {
        return 0;
    }

}
