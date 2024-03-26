package de.telran.lection3.interfaces;


public class SomeInterfaceImpl implements SomeInterface {

    @Override
    public void someMethod() {
        System.out.println("someMethod");
    }

    @Override
    public String someMethod(String s) {
        return s;
    }

    @Override
    public void defaultMethod() {
//        SomeInterface.super.defaultMethod();
        System.out.println("SomeInterfaceImpl impementation of default method");
    }


    public static void main(String[] args) {
        SomeInterface someInterface = new SomeInterfaceImpl();
        someInterface.someMethod();
        System.out.println(someInterface.someMethod("param"));
        someInterface.defaultMethod();

        someInterface = new SomeInterfaceImp2();
        someInterface.someMethod();
        System.out.println(someInterface.someMethod("param"));

        System.out.println(SomeInterface.number);
        SomeInterface.staticMethod();

        someInterface.defaultMethod();
    }
}

