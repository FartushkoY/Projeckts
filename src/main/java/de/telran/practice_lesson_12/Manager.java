package de.telran.practice_lesson_12;

import java.util.Objects;

public class Manager {
    private String name;
    private Integer id;
    private int percent;

    public Manager(String name, Integer id, int percent) {
        this.name = name;
        this.id = id;
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", percent=" + percent +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
