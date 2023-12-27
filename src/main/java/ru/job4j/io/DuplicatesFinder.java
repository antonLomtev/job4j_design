package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        searchDuplicates(Paths.get(".")).forEach((key, value) ->  System.out.println(key.getName() + " ---- " + value));
    }

    public static Map<FileProperty, List<String>> searchDuplicates(Path path) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(path, duplicatesVisitor);
        return duplicatesVisitor.getData();
    }
}
