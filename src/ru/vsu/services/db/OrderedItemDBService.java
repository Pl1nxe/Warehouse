package ru.vsu.services.db;

import ru.vsu.repository.Stored;

import java.sql.ResultSet;
import java.util.List;

public class OrderedItemDBService implements DataBaseService {

    @Override
    public void add(Stored obj) {

    }

    @Override
    public void removeByID(Integer id) {

    }

    @Override
    public Stored getByID(Integer id) {
        return null;
    }

    @Override
    public List<Stored> getAllFromDB() {
        return null;
    }

    @Override
    public void viewDataBase() {

    }

    @Override
    public Stored getByResultSet(ResultSet rs) {
        return null;
    }
}
