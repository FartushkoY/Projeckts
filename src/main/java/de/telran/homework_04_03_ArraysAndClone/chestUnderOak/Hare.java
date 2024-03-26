package de.telran.homework_04_03_ArraysAndClone.chestUnderOak;

public class Hare implements Cloneable{
    private String title;
    private Duck duck;

    public Hare(String title, Duck duck) {
        this.title = title;
        this.duck = duck;
    }

    @Override
    public Hare clone() throws CloneNotSupportedException {
        Hare cloned = (Hare) super.clone();
        cloned.duck = duck.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Hare{" +
                "title='" + title + '\'' +
                ", duck=" + duck +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duck getDuck() {
        return duck;
    }

    public void setDuck(Duck duck) {
        this.duck = duck;
    }
}
