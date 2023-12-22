package ru.job4j.io;

import java.io.*;
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

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter writer = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)
                )
        )) {
            for (String s : data) {
                writer.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
        new LogFilter("data/log.txt").saveTo("data/404.txt");
    }
}
