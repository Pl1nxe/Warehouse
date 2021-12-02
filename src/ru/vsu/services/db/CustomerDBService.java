package ru.vsu.services.db;

import ru.vsu.customers.Customer;
import ru.vsu.customers.LegalPerson;
import ru.vsu.customers.PrivatePerson;
import ru.vsu.database.DataBase;
import ru.vsu.repository.Stored;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBService implements DataBaseService {

    private static CustomerDBService INSTANCE;
    private static DataBase db;


    public static CustomerDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerDBService();
            db = DataBase.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Stored obj) {
        try {
            Customer customer = (Customer) obj;
            db.executeSelect("INSERT INTO customer (itn, address) VALUES (" + customer.getITN() + ", `"
                    + customer.getAddress() + "`);");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void removeByID(Integer id) {
        db.executeSelect("DELETE FROM customer WHERE itn=" + id + ";");
    }

    @Override
    public Stored getByID(Integer id) {
        ResultSet rs = db.executeSelect("SELECT * FROM customer WHERE itn=" + id);
        return getByResultSet(rs);
    }

    @Override
    public List<Stored> getAllFromDB() {
        List<Stored> list = new ArrayList<>();
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
        List<Stored> list = getAllFromDB();
        System.out.println("DatBase clientele:");
        for (Stored customer : list) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public Stored getByResultSet(ResultSet rs) {
        try {
            return switch (rs.getString("type")) {
                case "LegalPerson" -> new LegalPerson(
                        rs.getString("nameOfOrganization"),
                        rs.getInt("itn"),
                        rs.getString("address")
                );
                case "PrivatePerson" -> new PrivatePerson(
                        rs.getString("fullName"),
                        rs.getString("birthDate"),
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
}
