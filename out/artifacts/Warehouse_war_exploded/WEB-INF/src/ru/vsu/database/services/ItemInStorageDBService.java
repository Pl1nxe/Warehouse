package ru.vsu.database.services;

import ru.vsu.database.ConnectionManager;
import ru.vsu.database.objects.ItemInStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemInStorageDBService implements SideTable<ItemInStorage> {

    private static ItemInStorageDBService INSTANCE;
    private static ConnectionManager db;


    public static ItemInStorageDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ItemInStorageDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }


    @Override
    public void add(Integer warehouseNum, Integer itemArticle) {
        try {
            db.executeUpdate("INSERT INTO item_in_storage (warehouse_num, item_article) VALUES (" +
                    warehouseNum + ", " + itemArticle + ");");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Integer itemArticle) {
        db.executeUpdate("DELETE FROM item_in_storage WHERE item_article=" + itemArticle + ";");
        ItemDBService.getInstance().removeByID(itemArticle);
    }

    @Override
    public void removeAll(Integer warehouseNum) {
        db.executeUpdate("DELETE FROM item_in_storage WHERE warehouse_num=" + warehouseNum + ";");
    }

    @Override
    public List<ItemInStorage> getAllFromDB() {
        List<ItemInStorage> itemsInStorage = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM item_in_storage");
            while (rs.next())
                itemsInStorage.add(new ItemInStorage(
                        rs.getInt("warehouse_num"),
                        rs.getInt("item_article")
                ));
            return itemsInStorage;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " ItemInStorageDBService.getAllFromDB()");
            return null;
        }
    }

    @Override
    public int getCount() {
        return getAllFromDB().size();
    }
}
