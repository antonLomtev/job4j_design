package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    public final int cacheDir = 1;
    public final int loadFileToCache = 2;
    public final int getCacheFile = 3;

    public final String select = "Выберите меню";
    public final String pathToDir = "Введите путь к дирректории:";
    public final String exit = "Конец работы";

    public final String menu = """
                Введите 1 - указать директорию для кэширования.
                Введите 2 - загрузить содержимое в кэш.
                Введите 3 - получить содержимое кэша.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        Scanner scanner = new Scanner(System.in);
        emulator.start(scanner);
    }

    private void start(Scanner scanner) {
        boolean run = true;
        String path = null;
        String text = null;
        while (run) {
            System.out.println(menu);
            System.out.println(select);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (cacheDir == userChoice) {
                System.out.println(pathToDir);
                path = scanner.nextLine();
            } else if (loadFileToCache == userChoice) {
                System.out.println("Введите имя файла: ");
                text = scanner.nextLine();
                new DirFileCache(path).get(text);
            } else if (getCacheFile == userChoice) {
                System.out.println(new DirFileCache(path).get(text));
            } else {
                run = false;
                System.out.println(exit);
            }
        }
    }
}
