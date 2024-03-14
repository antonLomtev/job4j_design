package ru.job4j.ood.lsp.product;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Food apple = new Apple("apple", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  3, 16), 122);
        Food bread = new Bread("bread", LocalDate.of(2024, 3, 10), LocalDate.of(2024,  3, 14), 40);
        Food milk = new Milk("milk", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  3, 10), 100);
        Food sugar = new Sugar("sugar", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  12, 10), 100);
        Food tea = new Tea("tea", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  12, 10), 200);
        Food milk2 = new Milk("milk2", LocalDate.of(2024, 3, 4), LocalDate.of(2024,  3, 14), 200);
        List<Food> foods = new ArrayList<>();
        foods.add(apple);
        foods.add(bread);
        foods.add(milk);
        foods.add(sugar);
        foods.add(tea);
        foods.add(milk2);
        ControlQuality c = new ControlQuality();
        AbstractStore a = new Shop();
        Store store = new Shop();
        for (Food e : foods) {
            store.add(e);
        }
        for (Food z : store.findAll()) {
            System.out.println(z.getName() + " - " + z.getPrice());
        }
        for (Food f : c.controlProducts(a, foods)) {
            System.out.println(f.getCategoryStore());
        }
    }
}
