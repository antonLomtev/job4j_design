package ru.job4j.ood.lsp;

public class Order {
    protected int cost;
    protected int discount;

    public Order(int cost) {
        this.cost = cost;
        this.discount = 1000;
        conditionDiscount(cost);
    }

    public void conditionDiscount(int cost) {
        if (cost > 15000) {
            cost -= discount;
        }
    }
}
