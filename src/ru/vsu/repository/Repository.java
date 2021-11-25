package ru.vsu.repository;

import java.util.List;

public interface Repository {

    List<Stored> getAll();

    void add(Stored stored);

    void deleteByIndex(int index);

    void replaceAll(Stored existing, Stored toReplace);

}
