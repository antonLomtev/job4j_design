package ru.job4j.ood.dip;

import java.util.List;

public class Order {
    private List<Product> products;

    /**
     * явно привязываемся к списку только продуктов
     */

    public List<Product> getProducts() {
        return products;
    }
}
