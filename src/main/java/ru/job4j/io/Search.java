package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validation(args);
        Path start = Paths.get(args[0]);
        search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searchFiles = new SearchFiles(condition);
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }

    private static void validation(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Fill in all parameters.");
        }
        if (!Files.exists(Paths.get(args[0]))) {
            throw new IllegalArgumentException("Directory/File not found.");
        }
        if (!args[1].startsWith(".") && args[1].length() < 2) {
            throw new IllegalArgumentException("Incorrect format file.");
        }
    }
}
