package de.telran.lection18;

import java.util.List;

public class Box <Item>{
    private Item item;

    public Box(Item item) {
        this.item = item;
    }

    public Box() {
    }

    public Item getItem() {
        return item;
    }

    public void put(Item item) {
        this.item = item;
    }

    public Item get() {
        return item;
    }

    public Item remove() {
        Item item1 = item;
        item = null;
        return item1;
    }
}
