package ru.vsu.database.services;

import ru.vsu.database.ConnectionManager;
import ru.vsu.repository.Stored;
import ru.vsu.repository.Warehouse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDBService implements DataBaseService<Warehouse> {

    private static WarehouseDBService INSTANCE;
    private static ConnectionManager db;


    public static WarehouseDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WarehouseDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Warehouse warehouse) {
        try {
            db.executeUpdate("INSERT INTO warehouse (number, address) VALUES (" +
                    warehouse.getNumber() + ", \"" + warehouse.getAddress() + "\");");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        List<Integer> articles = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM item_in_storage WHERE warehouse_num=" + id + ";");
            while (rs.next())
                articles.add(rs.getInt("item_article"));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (Integer i : articles)
            ItemDBService.getInstance().removeByID(i);
        db.executeUpdate("DELETE FROM warehouse WHERE number=" + id + ";");
    }

    @Override
    public Warehouse getByID(Integer id) {
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM warehouse WHERE number=" + id);
            rs.next();
            Warehouse warehouse = getByResultSet(rs);
            rs.close();
            return warehouse;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Warehouse> getAllFromDB() {
        List<Warehouse> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM warehouse");
            while (rs.next())
                list.add(getByResultSet(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void viewDataBase() {
        List<Warehouse> list = getAllFromDB();
        System.out.println("Warehouses:");
        for (Stored item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Warehouse getByResultSet(ResultSet rs) {
        try {
            return new Warehouse(
                    rs.getInt("number"),
                    rs.getString("address")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int getCount() {
        return getAllFromDB().size();
    }
}
