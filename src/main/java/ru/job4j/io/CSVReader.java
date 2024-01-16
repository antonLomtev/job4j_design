package ru.job4j.io;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        String delimiter = argsName.get("delimiter");
        Path path = Path.of(argsName.get("path"));
        String out = argsName.get("out");
        List<String> filters = Arrays.asList(argsName.get("filter").split(","));

        try (Scanner scanner = new Scanner(path);
             PrintStream print = "stdout".equals(out) ? System.out : new PrintStream(out)) {
            StringJoiner joiner = new StringJoiner(System.lineSeparator());
            List<Integer> indexes = new ArrayList<>();
             boolean isFirstLine = true;
             while (scanner.hasNext()) {
                 List<String> line = Arrays.asList(scanner.nextLine().split(delimiter));
                 if (isFirstLine) {
                     indexes = filters.stream().map(line::indexOf).collect(Collectors.toList());
                     isFirstLine = false;
                 }
                 StringJoiner stringJoiner = new StringJoiner(delimiter);
                 for (Integer s : indexes) {
                     stringJoiner.add(line.get(s));
                 }
                 joiner.add(stringJoiner.toString());
             }
             print.println(joiner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validate(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Not all parameters have been entered");
        }
        ArgsName argsName = ArgsName.of(args);
        Path path = Path.of(argsName.get("path"));
        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format("File not found %s", path));
        }
        if (!",".equals(argsName.get("delimiter")) && !";".equals(argsName.get("delimiter"))) {
            throw new IllegalArgumentException("Wrong format delimiter. Use ';', ','");
        }
    }

    public static void main(String[] args) {
        validate(args);
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
