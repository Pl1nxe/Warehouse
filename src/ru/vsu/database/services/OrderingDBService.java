package ru.vsu.database.services;

import ru.vsu.database.ConnectionManager;
import ru.vsu.order.Ordering;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderingDBService implements DataBaseService<Ordering> {

    private static OrderingDBService INSTANCE;
    private static ConnectionManager db;


    public static OrderingDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderingDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Ordering order) {
        try {
            db.executeUpdate("INSERT INTO ordering (reference_number, customer_itn, date) VALUES (" +
                    order.getReferenceNumber() + ", " + order.getCustomerITN() + ", `" + order.getDate() + "`);");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM ordering WHERE reference_number=" + id + ";");
    }

    @Override
    public Ordering getByID(Integer id) {
        ResultSet rs = db.executeSelect("SELECT * FROM ordering WHERE reference_number=" + id);
        return getByResultSet(rs);
    }

    @Override
    public List<Ordering> getAllFromDB() {
        List<Ordering> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM ordering");
            while (rs.next())
                list.add(getByResultSet(rs));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void viewDataBase() {
        List<Ordering> list = getAllFromDB();
        System.out.println("Orders:");
        for (Ordering item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Ordering getByResultSet(ResultSet rs) {
        try {
            return new Ordering(
                    rs.getInt("reference_number"),
                    rs.getInt("customer_itn"),
                    rs.getString("date")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("OrderingDBService line 80");
            return null;
        }
    }

    @Override
    public int getCount() {
        return getAllFromDB().size();
    }
}
