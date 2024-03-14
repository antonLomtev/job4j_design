package ru.job4j.ood.lsp.product;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private List<Food> products = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (checkCategoryFood(food)) {
            products.add(food);
        }
    }

    @Override
    public List<Food> findAll() {
        return products;
    }

    @Override
    public boolean checkCategoryFood(Food food) {
        return false;
    }
}
