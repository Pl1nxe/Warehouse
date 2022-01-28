package ru.vsu.database.services;

import ru.vsu.database.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceListDBService {

    private static PriceListDBService INSTANCE;
    private static ConnectionManager db;


    public static PriceListDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PriceListDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    public double getLastPrice(Integer article) {
        double price = 0;
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM price_list WHERE item_article=" +
                    article + " ORDER BY date DESC");
            rs.next();
            price = rs.getDouble("price");
            rs.close();
            return price;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return price;
        }
    }
}
