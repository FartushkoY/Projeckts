package de.telran.homework_04_03_ArraysAndClone.chestUnderOak;

public class Needle implements Cloneable {
    private String title;


    public Needle(String title) {
        this.title = title;

    }

    @Override
    public String toString() {
        return "Needle{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public Needle clone() throws CloneNotSupportedException {
        return (Needle) super.clone();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
