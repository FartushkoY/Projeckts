package de.telran.lection2.initsteps;

public class Child extends Parent {

    static {
        System.out.println("child static init");
    }

    {
        System.out.println("child non static init");
    }

    public Child() {
//        super();
        System.out.println("child constructor");
    }

    public static void staticMethod() {
        System.out.println("child staticMethod");
    }
}
