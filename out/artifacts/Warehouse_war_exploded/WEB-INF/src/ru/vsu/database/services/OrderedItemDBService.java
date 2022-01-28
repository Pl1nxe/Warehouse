package ru.vsu.database.services;

import ru.vsu.database.ConnectionManager;
import ru.vsu.database.objects.OrderedItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedItemDBService {

    private static OrderedItemDBService INSTANCE;
    private static ConnectionManager db;


    public static OrderedItemDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderedItemDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    public void add(OrderedItem orderedItem) {
        try {
            db.executeUpdate("INSERT INTO ordered_item (order_ref_num, item_article, price, count) VALUES (" +
                    orderedItem.getOrderRefNum() + ", " + orderedItem.getItemArticle() + ", "
                    + orderedItem.getPrice() + ", " + orderedItem.getCount() + ");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(Integer itemArticle) {
        db.executeUpdate("DELETE FROM ordered_item WHERE item_article=" + itemArticle + ";");
    }

    public void removeAll(Integer orderRefNum) {
        db.executeUpdate("DELETE FROM ordered_item WHERE order_ref_num=" + orderRefNum + ";");
    }

    public List<OrderedItem> getAllFromDB() {
        List<OrderedItem> orderedItems = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM ordered_item");
            while (rs.next())
                orderedItems.add(new OrderedItem(
                        rs.getInt("order_ref_num"),
                        rs.getInt("item_article"),
                        rs.getDouble("price"),
                        rs.getInt("count")
                ));
            rs.close();
            return orderedItems;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " OrderedItemDBService.getAllFromDB()");
            return null;
        }
    }

    public int getCount() {
        return getAllFromDB().size();
    }
}
