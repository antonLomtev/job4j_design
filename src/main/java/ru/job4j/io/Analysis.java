package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            String start = "";
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] status = line.split(" ");
                if (Integer.valueOf(status[0]).equals(400) || Integer.valueOf(status[0]).equals(500)) {
                    if (start.isEmpty()) {
                        start = status[1];
                    }
                } else {
                    if (!start.isEmpty()) {
                        out.write(start + "; " + status[1] + ";" + "\n");
                        start = "";
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
