package ru.job4j.ood.lsp.parking;

public abstract class Auto {
    private int size;

    public Auto(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
