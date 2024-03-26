package de.telran.homework_04_03_ArraysAndClone.chestUnderOak;

public class Duck implements Cloneable{
    private String title;
    private Egg egg;

    public Duck(String title, Egg egg) {
        this.title = title;
        this.egg = egg;
    }

    @Override
    public Duck clone() throws CloneNotSupportedException {
        Duck cloned = (Duck) super.clone();
        cloned.egg = egg.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "title='" + title + '\'' +
                ", egg=" + egg +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }
}
