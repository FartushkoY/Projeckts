package de.telran.lesson_07_03;

import java.util.List;

public interface WorldDAO<T, Id> {

    T getById(Id id);

    List<T> getAll();

    void save(T t);

    void delete(Id id);

    void update(Id id);


}
