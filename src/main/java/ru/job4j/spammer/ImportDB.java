package ru.job4j.spammer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties config;
    private String dump;

    public ImportDB(Properties config, String dump) {
        this.config = config;
        this.dump = dump;
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("spammer.properties")) {
            config.load(in);
        }
        ImportDB dataBase = new ImportDB(config, "./dump.txt");
        dataBase.save(dataBase.load());
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            reader.lines().forEach(s -> {
                String[] values = s.split(";");
                validate(values);
                users.add(new User(values[0], values[1]));
            });
        }
        return users;
    }

    private void validate(String[] values) {
        if (values.length < 2 || values[0].isEmpty() || values[1].isEmpty()) {
            throw new IllegalArgumentException("Incorrect format values. Use format: name; email;.");
        }
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(config.getProperty("driver_class"));
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("url"),
                config.getProperty("login"),
                config.getProperty("password")
        )) {
            for (User user : users) {
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement("insert into users(name, email) values(?, ?)")) {
                    preparedStatement.setString(1, user.name);
                    preparedStatement.setString(2, user.email);
                    preparedStatement.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
