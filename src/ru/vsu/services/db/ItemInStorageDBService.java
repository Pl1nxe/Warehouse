package ru.vsu.services.db;

import ru.vsu.database.DataBase;

public class ItemInStorageDBService implements SideTable {

    private static ItemInStorageDBService INSTANCE;
    private static DataBase db;


    public static ItemInStorageDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ItemInStorageDBService();
            db = DataBase.getInstance();
        }
        return INSTANCE;
    }


    @Override
    public void add(Integer warehouseNum, Integer itemArticle) {
        try {
            db.executeSelect("INSERT INTO item_in_storage (warehouse_num, item_article) VALUES (" +
                    warehouseNum + ", " + itemArticle + ");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer itemArticle) {
        db.executeSelect("DELETE FROM item_in_storage WHERE item_article=" + itemArticle + ";");
    }

    @Override
    public void removeAll(Integer warehouseNum) {
        db.executeSelect("DELETE FROM item_in_storage WHERE warehouse_num=" + warehouseNum + ";");
    }
}
