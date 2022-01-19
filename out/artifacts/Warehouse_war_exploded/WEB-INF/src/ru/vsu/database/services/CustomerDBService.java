package ru.vsu.database.services;

import ru.vsu.customers.Customer;
import ru.vsu.customers.CustomerType;
import ru.vsu.customers.LegalPerson;
import ru.vsu.customers.PrivatePerson;
import ru.vsu.database.ConnectionManager;
import ru.vsu.repository.Stored;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBService implements DataBaseService<Customer> {

    private static CustomerDBService INSTANCE;
    private static ConnectionManager db;


    public static CustomerDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Customer customer) {
        try {
            int type = CustomerType.getTypeFromClass(customer.getClass()).getNum();
            switch (type) {
                case 1 -> db.executeUpdate("INSERT INTO customer (itn, type, name, address) VALUES (" +
                        customer.getITN() + ", " + type + ", `" + customer.getName() + "`, `"
                        + customer.getAddress() + "`);");
                case 2 -> db.executeUpdate("INSERT INTO customer (itn, type, name, address, birthdate) VALUES (" +
                        customer.getITN() + ", " + type + ", `" + customer.getName() + "`, `"
                        + customer.getAddress() + "`, `" + customer.getBirthDate() + "`);");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM customer WHERE itn=" + id + ";");
    }

    @Override
    public Customer getByID(Integer id) {
        ResultSet rs = db.executeSelect("SELECT * FROM customer WHERE itn=" + id);
        return getByResultSet(rs);
    }

    @Override
    public List<Customer> getAllFromDB() {
        List<Customer> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM customer");
            while (rs.next())
                list.add(getByResultSet(rs));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void viewDataBase() {
        List<Customer> list = getAllFromDB();
        System.out.println("DataBase clientele:");
        for (Stored customer : list) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public Customer getByResultSet(ResultSet rs) {
        try {
            return switch (rs.getInt("type")) {
                case 1 -> new LegalPerson(
                        rs.getString("name"),
                        rs.getInt("itn"),
                        rs.getString("address")
                );
                case 2 -> new PrivatePerson(
                        rs.getString("name"),
                        rs.getString("birthdate"),
                        rs.getInt("itn"),
                        rs.getString("address")
                );
                default -> null;
            };
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
