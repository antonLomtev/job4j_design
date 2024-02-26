package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Config config = new Config("src/main/resources/app.properties");
        config.load();
        Class.forName(config.values("driver_class"));
        try (Connection connection = DriverManager.getConnection(config.values("url"),
                config.values("login"), config.values("password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
