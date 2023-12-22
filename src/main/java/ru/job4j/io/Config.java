package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        Config config = new Config("data/pair_without_comment.properties");
        config.load();
        config.values("name");
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.isBlank() && !line.startsWith("#")) {
                    String[] strings = line.split("=");
                    if (strings.length < 2 || strings[0].isEmpty() || strings[1].isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                    this.values.put(strings[0], strings[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String values(String key) {
        if (values.get(key) == null) {
            throw new UnsupportedOperationException();
        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public Map<String, String> getValues() {
        return values;
    }
}
