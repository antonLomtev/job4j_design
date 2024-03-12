package ru.job4j.ood.lsp;

public class CoupeAuto extends Bus {
    public void run(int countPassenger) {
        if (countPassenger > 1) {
            System.out.println("no run");
        }
    }
}
