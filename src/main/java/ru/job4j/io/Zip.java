package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Not all parameters are specified");
        }

        ArgsName argsName = ArgsName.of(args);
        validate(argsName);

        Zip zip = new Zip();
        zip.packSingleFile(new File("./pom.xml"),
                           new File("./pom.zip"));

        Path source = Path.of(argsName.get("d"));
        List<Path> paths = Search.search(source, path -> !path.toString().endsWith(argsName.get("e")));
        zip.packFiles(paths, new File(argsName.get("o")));
    }

    private static void validate(ArgsName args) {
        if (!Files.isDirectory(Path.of(args.get("d")))) {
            throw new IllegalArgumentException(String.format("Path to the is incorrect : %s", args.get("d")));
        }

        if (!args.get("e").startsWith(".")) {
            throw new IllegalArgumentException(String.format("Incorrect values : %s", args.get("e")));
        }

        if (!args.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Output file : %s incorrect", args.get("o")));
        }
    }
}
