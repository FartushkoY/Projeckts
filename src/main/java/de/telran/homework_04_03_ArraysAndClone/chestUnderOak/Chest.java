package de.telran.homework_04_03_ArraysAndClone.chestUnderOak;

public class Chest implements Cloneable {
    private String title;
    private Hare hare;


    public Chest(String title, Hare hare) {
        this.title = title;
        this.hare = hare;
    }


    public void clear() {
        title = null;
        hare = null;
    }

    public Chest shallowCopy() {
        return new Chest(title, hare);
    }

    public Chest deepCopy() {
//        return new Chest(title, new Hare(hare.getTitle(), new Duck(duck.getTitle(), new Egg(getTitle(), new Needle(getTitle())))));
        Needle newNeedle = new Needle(hare.getDuck().getEgg().getNeedle().getTitle());
        Egg newEgg = new Egg(hare.getDuck().getEgg().getTitle(), newNeedle);
        Duck newDuck = new Duck(hare.getDuck().getTitle(), newEgg);
        Hare newHare = new Hare(hare.getTitle(), newDuck);
        return new Chest(title, newHare);
    }



    @Override
    public Chest clone() throws CloneNotSupportedException {
        Chest cloned = (Chest) super.clone();
        cloned.hare = hare.clone();
        return cloned;
    }



    @Override
    public String toString() {
        return "Chest{" +
                "title='" + title + '\'' +
                ", hare=" + hare +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Hare getHare() {
        return hare;
    }

    public void setHare(Hare hare) {
        this.hare = hare;
    }
}
