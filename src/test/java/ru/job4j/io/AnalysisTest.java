package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {
    @Test
    void whenTwoStopServer(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        Analysis analysis = new Analysis();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("300 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        File target = tempDir.resolve("target.txt").toFile();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(builder::append);
        }
        assertThat("10:57:01; 10:59:01;11:01:02; 11:02:02;").hasToString(builder.toString());
    }

    @Test
    void whenNoStopServer(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        Analysis analysis = new Analysis();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("300 10:59:01");
            out.println("200 11:02:02");
            out.println("200 11:03:02");
            out.println("300 11:05:02");
        }
        File target = tempDir.resolve("target.txt").toFile();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(builder::append);
        }
        assertThat("").hasToString(builder.toString());
    }

    @Test
    void whenOneStopServer(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        Analysis analysis = new Analysis();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("300 10:57:01");
            out.println("200 10:58:01");
            out.println("300 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        File target = tempDir.resolve("target.txt").toFile();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(builder::append);
        }
        assertThat("11:01:02; 11:02:02;").hasToString(builder.toString());
    }
}