package de.telran.homework_04_03_ArraysAndClone.chestUnderOak;

public class Egg implements Cloneable{
    private String title;
    private Needle needle;

    public Egg(String title, Needle needle) {
        this.title = title;
        this.needle = needle;
    }

    @Override
    public Egg clone() throws CloneNotSupportedException {
        Egg cloned = (Egg) super.clone();
        cloned.needle = needle.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "title='" + title + '\'' +
                ", needle=" + needle +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Needle getNeedle() {
        return needle;
    }

    public void setNeedle(Needle needle) {
        this.needle = needle;
    }
}
