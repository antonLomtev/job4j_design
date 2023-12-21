package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/event.txt")) {
            int read;
            StringBuilder builder = new StringBuilder();
            while ((read = in.read()) != -1) {
                builder.append((char) read);
            }
            String[] values = builder.toString().split(System.lineSeparator());
            for (String val : values) {
                System.out.println(Integer.valueOf(val) % 2 == 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
