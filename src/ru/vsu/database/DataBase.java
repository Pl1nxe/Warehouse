package ru.vsu.database;

import java.sql.*;

public class DataBase {
    private static DataBase INSTANCE;

    private final static String DB_URL = "jdbc:mysql://localhost:3306/warehouse_system";
    private final static String DB_USER = "mysql";
    private final static String DB_PASS = "mysql";
    private Statement statement;

    public static DataBase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataBase();
            INSTANCE.connect();
        }
        return INSTANCE;
    }

    private void connect() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public ResultSet executeSelect(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return resultSet;
    }
}
