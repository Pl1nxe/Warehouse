package ru.vsu.database.services;

import java.sql.ResultSet;
import java.util.List;

public interface DataBaseService<Stored> {

    void add(Stored obj);

    void removeByID(Integer id);

    Stored getByID(Integer id);

    List<Stored> getAllFromDB();

    void viewDataBase();

    Stored getByResultSet(ResultSet rs);

    int getCount();

}
