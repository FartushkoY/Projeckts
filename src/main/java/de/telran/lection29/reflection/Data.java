package de.telran.lection29.reflection;

public class Data {

    public String publicValue;

    private  Double privateValue;

    public Data (){

    }

    public Data(String publicValue, Double privateValue) {
        this.publicValue = publicValue;
        this.privateValue = privateValue;
    }

    public void publicMethod() {
        System.out.println("publicMethod() invoced");
        System.out.println("Public Value: " + publicValue);
    }


    private void privateMethod (Double value) {
        System.out.println("privateMethod() invoced");
        privateValue += value;
        System.out.println("Private value: " + privateValue);
    }

    public String getPublicValue() {
        return publicValue;
    }

    public Double getPrivateValue() {
        return privateValue;
    }
}
