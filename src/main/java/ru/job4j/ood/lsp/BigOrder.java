package ru.job4j.ood.lsp;

public class BigOrder extends Order {

    public BigOrder(int cost) {
        super(cost);
    }

    public void conditionDiscount(int cost) {
        if (cost > 100000) {
            cost -= 10000;
        }
    }
}
