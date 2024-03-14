package ru.job4j.ood.lsp.product;

public class Trash extends AbstractStore {

    @Override
    public boolean checkCategoryFood(Food food) {
        return food.getCategoryStore() == 3;
    }
}
