package ru.job4j.io.find;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchCriteria {

    public static void main(String[] args) throws IOException {
        validate(args);
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.findByCriteriaAndWriteToFile(ArgsName.of(args));
    }

    public void findByCriteriaAndWriteToFile(ArgsName argsName) throws IOException {
        List<Path> result = searchResultList(Path.of(argsName.get("d")),
                                                     argsName.get("t"),
                                                      argsName.get("n"));
        PrintStream ps = new PrintStream(new FileOutputStream(argsName.get("o")));
        result.forEach(ps::println);
    }

    private static List<Path> searchResultList(Path root, String criteria, String text) throws IOException {
        List<Path> result = new ArrayList<>();
        if ("name".equals(criteria)) {
            result = Search.search(root, path -> path.toFile().getName().endsWith(text));
        }
        if ("regex".equals(criteria)) {
            Pattern pattern = Pattern.compile(text);
            result = Search.search(root, path -> pattern.matcher(path.toFile().getName()).find());
        }
        if ("mask".equals(criteria)) {
            result = Search.search(root, path -> path.toFile().getName()
                    .matches(text.replace(".", "\\.")
                                 .replace("*", ".*")
                                 .replace("?", ".")));
        }
        return result;
    }

    private static void validate(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Please, enter all parameters");
        }
        ArgsName argsName = ArgsName.of(args);
        Path path = Path.of(argsName.get("d"));
        String findCriteria = argsName.get("t");
        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format("File not found %s", path.toAbsolutePath()));
        }
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException(String.format("Directory not found %s", path.toAbsolutePath()));
        }
        if (!"name".equals(findCriteria) && !"regex".equals(findCriteria) && !"mask".equals(findCriteria)) {
            throw new IllegalArgumentException("Incorrect search parameter! Use parameters: \"name\" or \"regex\" or \"mask\"");
        }
    }
}
