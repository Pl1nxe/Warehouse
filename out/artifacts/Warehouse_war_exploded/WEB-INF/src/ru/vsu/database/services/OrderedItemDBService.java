package ru.vsu.database.services;

import ru.vsu.database.ConnectionManager;
import ru.vsu.database.objects.OrderedItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedItemDBService implements SideTable<OrderedItem> {

    private static OrderedItemDBService INSTANCE;
    private static ConnectionManager db;


    public static OrderedItemDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderedItemDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }


    @Override
    public void add(Integer orderRefNum, Integer itemArticle) {
        try {
            db.executeUpdate("INSERT INTO ordered_item (order_ref_num, item_article) VALUES (" +
                    orderRefNum + ", " + itemArticle + ");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer itemArticle) {
        db.executeUpdate("DELETE FROM ordered_item WHERE item_article=" + itemArticle + ";");
    }

    @Override
    public void removeAll(Integer orderRefNum) {
        db.executeUpdate("DELETE FROM ordered_item WHERE order_ref_num=" + orderRefNum + ";");
    }

    @Override
    public List<OrderedItem> getAllFromDB() {
        List<OrderedItem> orderedItems = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM ordered_item");
            while (rs.next())
                orderedItems.add(new OrderedItem(
                        rs.getInt("order_ref_num"),
                        rs.getInt("item_article")
                ));
            return orderedItems;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " OrderedItemDBService.getAllFromDB()");
            return null;
        }
    }

    @Override
    public int getCount() {
        return getAllFromDB().size();
    }
}
