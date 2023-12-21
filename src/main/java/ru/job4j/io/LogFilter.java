package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> temp = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("data/log.txt"))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] strings = line.split(" ");
                if (Integer.valueOf(strings[strings.length - 2]) == 404) {
                    temp.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
    }
}
