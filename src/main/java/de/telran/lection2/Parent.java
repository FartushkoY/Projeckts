package de.telran.lection2;

public class Parent extends GrandParent {

    public int publicField = 10;
    private int privateField = 10;

    public void publicMethod() {
        System.out.println("Parent public method");
    }

    private void privateMethod() {
        System.out.println("Parent private method");
    }

    public int getPrivateField() {
        return privateField;
    }

    public void setPrivateField(int privateField) {
        this.privateField = privateField;
    }
}
