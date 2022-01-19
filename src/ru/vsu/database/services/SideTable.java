package ru.vsu.database.services;

import java.util.List;

public interface SideTable<T> {

    void add(Integer a, Integer b);

    void remove(Integer id);

    void removeAll(Integer id);

    List<T> getAllFromDB();

    int getCount();
}
