package de.telran.lection2;

public class UseChildAndParent {

    public static void main(String[] args) {
//        Parent parent = new Parent();
//        Child child = new Child();
//
//        System.out.println(child.publicField);
//
//        System.out.println(child.getPrivateField());
//        child.publicMethod();

//        Parent entity = null;
//        boolean condition = false;
//
//        if (condition) {
//            entity = new Parent();
//        } else {
//            entity = new Child();
//        }
//
//        entity.publicMethod();

//        Object childTwo = new ChildTwo();
        Child child = new Child();
        ChildTwo childTwo = new ChildTwo();

        processEntity(child);
        processEntity(childTwo);
    }


    public static void processEntity(Parent parent) {
//        ((Child)parent).method();

        if (parent.getClass().equals(Child.class)) {
            Child child = (Child) parent;
            child.method();
        }
        System.out.println("processing " + parent.getClass().getSimpleName());
    }

}
