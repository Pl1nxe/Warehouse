package ru.vsu.services.db;

import ru.vsu.database.DataBase;

public class OrderedItemDBService implements SideTable {

    private static OrderedItemDBService INSTANCE;
    private static DataBase db = DataBase.getInstance();


    public static OrderedItemDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderedItemDBService();
            db = DataBase.getInstance();
        }
        return INSTANCE;
    }


    @Override
    public void add(Integer orderRefNum, Integer itemArticle) {
        try {
            db.executeSelect("INSERT INTO ordered_item (order_ref_num, item_article) VALUES (" +
                    orderRefNum + ", " + itemArticle + ");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer itemArticle) {
        db.executeSelect("DELETE FROM ordered_item WHERE item_article=" + itemArticle + ";");
    }

    @Override
    public void removeAll(Integer orderRefNum) {
        db.executeSelect("DELETE FROM ordered_item WHERE order_ref_num=" + orderRefNum + ";");
    }
}
