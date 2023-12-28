package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: " + "'" + key + "'" + " is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String[] parameters = args[i].split("=", 2);
            values.put(parameters[0].substring(1), parameters[1]);
        }
    }

    private static void validation(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String parameters : args) {
            if (!parameters.contains("=")) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain an equal sign", parameters));
            }
            String[] temp = parameters.split("=", 2);
            if (temp[0].substring(1).isBlank()) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain a key", parameters));
            }
            if (temp[1].isBlank()) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not contain a value", parameters));
            }
            if (!parameters.startsWith("-")) {
                throw new IllegalArgumentException(
                        String.format("Error: This argument '%s' does not start with a '-' character", parameters));
            }
        }
    }

    public static ArgsName of(String[] args) {
        validation(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
