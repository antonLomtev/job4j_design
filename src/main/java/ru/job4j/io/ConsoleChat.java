package ru.job4j.io;

import java.util.ArrayList;
import java.util.List;

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

    public void run() {

    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();

        return new ArrayList<>();
    }

    private void saveLog(List<String> log) {

    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("", "");
        consoleChat.run();
    }
}
