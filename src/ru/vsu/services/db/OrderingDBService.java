package ru.vsu.services.db;

import ru.vsu.customers.Customer;
import ru.vsu.database.DataBase;
import ru.vsu.order.Order;
import ru.vsu.repository.Stored;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderingDBService implements DataBaseService<Order> {

    private static OrderingDBService INSTANCE;
    private static DataBase db = DataBase.getInstance();


    public static OrderingDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderingDBService();
            db = DataBase.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Order order) {
        try {
            db.executeSelect("INSERT INTO ordering (reference_number, customer_itn, date) VALUES (" +
                    order.getReferenceNumber() + ", " + order.getCustomerITN() + ", `" + order.getDate() + "`);");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeSelect("DELETE FROM ordering WHERE reference_number=" + id + ";");
    }

    @Override
    public Order getByID(Integer id) {
        ResultSet rs = db.executeSelect("SELECT * FROM ordering WHERE reference_number=" + id);
        return getByResultSet(rs);
    }

    @Override
    public List<Order> getAllFromDB() {
        List<Order> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM ordering;");
            while (rs.next())
                list.add(getByResultSet(rs));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void viewDataBase() {
        List<Order> list = getAllFromDB();
        System.out.println("Orders:");
        for (Stored item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Order getByResultSet(ResultSet rs) {
        try {
            return new Order(
                    rs.getInt("reference_number"),
                    (Customer) CustomerDBService.getInstance().getByID(rs.getInt("customer_itn")),
                    rs.getString("date")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
