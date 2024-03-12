package ru.job4j.ood.lsp;

public class Bus {
    int cuntPassenger;

    public void run(int countPassenger) {
        if (countPassenger < 20) {
            System.out.println("No run");
        } else {
            System.out.println("run");
        }
    }
}
