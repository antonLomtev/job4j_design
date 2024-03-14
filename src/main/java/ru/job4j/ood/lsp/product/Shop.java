package ru.job4j.ood.lsp.product;

public class Shop extends AbstractStore {
    @Override
    public boolean checkCategoryFood(Food food) {
        if (food.getCategoryStore() == 2) {
            food.setPrice(food.getPrice() * 0.8);
        }
        return food.getCategoryStore() == 1 || food.getCategoryStore() == 2;
    }
}
