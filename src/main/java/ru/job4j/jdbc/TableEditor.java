package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    public static void main(String[] args) throws Exception {
        Properties properties1 = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties1.load(in);
        }
        TableEditor tableEditor = new TableEditor(properties1);
        tableEditor.createTable("demo_table");
        tableEditor.addColumn("demo_table", "name", "text");
        tableEditor.renameColumn("demo_table", "name", "first_name");
        System.out.println(getTableScheme(tableEditor.getConnection(), "demo_table"));
        tableEditor.dropColumn("demo_table", "first_name");
        System.out.println(getTableScheme(tableEditor.getConnection(), "demo_table"));
        tableEditor.dropTable("demo_table");
    }

    private Connection getConnection() throws Exception {
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver_class");
        Class.forName(driver);
        return DriverManager.getConnection(url, login, password);
    }

    private void initConnection() throws Exception {
        connection = getConnection();
    }

    public void createTable(String tableName) throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists %s(id serial primary key);", tableName);
                statement.execute(sql);
            }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s drop column %s;", tableName, columnName);
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "drop table %s;", tableName);
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s add %s %s;", tableName, columnName, type);
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s rename column %s to %s;", tableName, columnName, newColumnName);
            statement.execute(sql);
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n", metaData.getColumnName(i), metaData.getColumnTypeName(i)));
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
