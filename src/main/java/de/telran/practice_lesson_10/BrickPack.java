package de.telran.practice_lesson_10;

import java.util.Objects;

public class BrickPack {
    private int id;
    private int count;

    public BrickPack(int id, int count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public String toString() {
        return "BrickPack{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrickPack brickPack = (BrickPack) o;
        return id == brickPack.id && count == brickPack.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }
}
