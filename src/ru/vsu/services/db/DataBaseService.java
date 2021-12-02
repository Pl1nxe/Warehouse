package ru.vsu.services.db;

import ru.vsu.repository.Stored;

import java.sql.ResultSet;
import java.util.List;

public interface DataBaseService {

    void add(Stored obj);

    void removeByID(Integer id);

    Stored getByID(Integer id);

    List<Stored> getAllFromDB();

    void viewDataBase() ;

    Stored getByResultSet(ResultSet rs);

}
