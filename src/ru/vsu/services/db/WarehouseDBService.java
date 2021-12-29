package ru.vsu.services.db;

import ru.vsu.database.DataBase;
import ru.vsu.repository.Stored;
import ru.vsu.repository.Warehouse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDBService implements DataBaseService<Warehouse> {

    private static WarehouseDBService INSTANCE;
    private static DataBase db = DataBase.getInstance();


    public static WarehouseDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WarehouseDBService();
            db = DataBase.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Warehouse warehouse) {
        try {
            db.executeSelect("INSERT INTO warehouse (number, address) VALUES (" +
                    warehouse.getNumber() + ", `" + warehouse.getAddress() + "`);");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeSelect("DELETE FROM warehouse WHERE number=" + id + ";");
    }

    @Override
    public Warehouse getByID(Integer id) {
        ResultSet rs = db.executeSelect("SELECT * FROM warehouse WHERE number=" + id);
        return getByResultSet(rs);
    }

    @Override
    public List<Warehouse> getAllFromDB() {
        List<Warehouse> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM warehouse");
            while (rs.next())
                list.add(getByResultSet(rs));
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
}
