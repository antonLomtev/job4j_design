package ru.job4j.ood.lsp;

public class MSIComputer extends Computer {
    public MSIComputer(String name, int memory) {
        super(name, memory);
    }

    public void setData(String name) {
        this.name = name;
        this.memory = 16000;
    }
}
