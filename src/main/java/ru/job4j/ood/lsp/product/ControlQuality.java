package ru.job4j.ood.lsp.product;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    public List<Food> controlProducts(Store store, List<Food> product) {
        for (Food f : product) {
            store.add(f);
        }
        return store.findAll();
    }

    public void resort(List<Store> stores) {
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.findAll());
            store.findAll().clear();
        }
        for (Store s : stores) {
            controlProducts(s, foods);
        }
    }
}
