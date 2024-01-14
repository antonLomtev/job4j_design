package ru.job4j.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswer;

    public ConsoleChat(String path, String botAnswer) {
        this.path = path;
        this.botAnswer = botAnswer;
    }

    public void run() throws IOException {
        List<String> log = new ArrayList<>();
        List<String> phrases = readPhrases();
        boolean isStop = false;
        boolean cancel = false;
        Scanner scanner = new Scanner(System.in);
        while (!cancel) {
            String text = scanner.nextLine();
            log.add(text + " - " + LocalDateTime.now());
            if (OUT.equals(text)) {
                cancel = true;
            }
            if (STOP.equals(text)) {
                isStop = true;
            }
            if (CONTINUE.equals(text)) {
                isStop = false;
            }
            if (!isStop) {
                String print = phrases.get(new Random().nextInt(phrases.size()));
                System.out.println(print);
                log.add(print + " - " + LocalDateTime.now());
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() throws IOException {
        return Files.readAllLines(Paths.get(botAnswer), StandardCharsets.UTF_8);
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat consoleChat = new ConsoleChat("./data/console_chat.txt", "./data/phrases.txt");
        consoleChat.run();
    }
}
