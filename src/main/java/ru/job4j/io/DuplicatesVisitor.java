package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<String>> data = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
            data.computeIfAbsent(fileProperty,
                    key -> new ArrayList<>()).add(file.toAbsolutePath().toString());
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, List<String>> getData() {
        return data;
    }
}
