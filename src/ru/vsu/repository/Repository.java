package ru.vsu.repository;

import java.util.List;

public interface Repository {

    List<Stored> getAll();

    void add(Stored stored);

    void deleteByIndex(int index);

    void removeByID(Integer id);

    void replaceAll(Stored existing, Stored toReplace);

}
