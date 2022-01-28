package ru.vsu.database.services;

import ru.vsu.database.ConnectionManager;
import ru.vsu.items.*;
import ru.vsu.repository.Stored;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDBService implements DataBaseService<Item> {

    private static ItemDBService INSTANCE;
    private static ConnectionManager db;


    public static ItemDBService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ItemDBService();
            db = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    @Override
    public void add(Item item) {
        try {
            int type = ItemType.getTypeFromClass(item.getClass()).getNumber();
            switch (type) {
                case 1 -> db.executeUpdate("INSERT INTO item (article, title, manufacturer, price, length, width, " +
                        "height, material) VALUES (" + item.getArticleNum() + ", \"" + item.getTitle() +
                        "\", \"" + item.getManufacturer() + "\", " + item.getPrice() + ", " + item.getLength() +
                        ", " + item.getWidth() + ", " + item.getHeight() + ", \"" + item.getMaterial() + "\");");
                case 2 -> db.executeUpdate("INSERT INTO item (article, title, manufacturer, price, length, " +
                        "thickness) VALUES (" + item.getArticleNum() + ", \"" + item.getTitle() +
                        "\", \"" + item.getManufacturer() + "\", " + item.getPrice() + ", " + item.getLength() +
                        ", " + item.getThickness() + ");");
                case 3 -> db.executeUpdate("INSERT INTO item (article, title, manufacturer, price, " +
                        "inner_diameter, outer_diameter, material) VALUES (" + item.getArticleNum() + ", \"" +
                        item.getTitle() + "\", \"" + item.getManufacturer() + "\", " + item.getPrice() + ", " +
                        item.getInnerDiameter() + ", " + item.getOuterDiameter() + ", \"" + item.getMaterial() + "\");");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateItem(Item item) {

    }


    @Override
    public void removeByID(Integer id) {
        db.executeUpdate("DELETE FROM item WHERE article=" + id + ";");
    }

    @Override
    public Item getByID(Integer id) {
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM item WHERE article=" + id);
            rs.next();
            Item item = getByResultSet(rs);
            rs.close();
            return item;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public List<Item> getByWarehouseNum(Integer warehouseNum) {
        List<Item> items = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM item WHERE article IN " +
                    "(SELECT item_article FROM item_in_storage WHERE warehouse_num=" + warehouseNum + ")");
            while (rs.next())
                items.add(getByResultSet(rs));
            rs.close();
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " ItemInStorageDBService.getAllFromDB()");
            return null;
        }
    }

    public int getType(Integer article) {
        try {
            ResultSet rs = db.executeSelect("SELECT type FROM item WHERE article=" + article);
            rs.next();
            int type = rs.getInt("type");
            rs.close();
            return type;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Item> getAllFromDB() {
        List<Item> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM item");
            while (rs.next())
                list.add(getByResultSet(rs));
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void viewDataBase() {
        List<Item> list = getAllFromDB();
        System.out.println("Items:");
        for (Stored item : list) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Item getByResultSet(ResultSet rs) {
        try {
            return switch (rs.getInt("type")) {
                case 1 -> new Beam(
                        rs.getInt("article"),
                        rs.getString("title"),
                        rs.getString("manufacturer"),
//                        rs.getInt("price"),
                        rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("height"),
                        rs.getString("material")
                );
                case 2 -> new Fitting(
                        rs.getInt("article"),
                        rs.getString("title"),
                        rs.getString("manufacturer"),
//                        rs.getInt("price"),
                        rs.getInt("length"),
                        rs.getInt("thickness")
                );
                case 3 -> new Pipe(
                        rs.getInt("article"),
                        rs.getString("title"),
                        rs.getString("manufacturer"),
//                        rs.getInt("price"),
                        rs.getInt("inner_diameter"),
                        rs.getInt("outer_diameter"),
                        rs.getString("material")
                );
                default -> null;
            };
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Item> getItemsByType(int type) {
        List<Item> list = new ArrayList<>();
        try {
            ResultSet rs = db.executeSelect("SELECT * FROM item WHERE type=" + type);
            while (rs.next())
                list.add(getByResultSet(rs));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public int getCount() {
        return getAllFromDB().size();
    }
}
