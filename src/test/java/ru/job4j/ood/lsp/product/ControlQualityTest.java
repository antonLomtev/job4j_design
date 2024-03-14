package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    @Test
    void whenAddOverdueFoodThenTrashAdd() {
        ControlQuality cQ = new ControlQuality();
        Food apple = new Apple("apple", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  4, 1), 122);
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
        Store store = new Trash();
        assertThat(cQ.controlProducts(store, foods).size()).isEqualTo(3);
        assertThat(cQ.controlProducts(store, foods)).contains(bread, milk, milk2);
    }

    @Test
    void whenAddSuitableFoodThenShopAdd() {
        ControlQuality cQ = new ControlQuality();
        Food apple = new Apple("apple", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  4, 1), 122);
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
        Store store = new Shop();
        assertThat(cQ.controlProducts(store, foods).size()).isEqualTo(1);
        assertThat(cQ.controlProducts(store, foods)).contains(apple);
    }

    @Test
    void whenAddLowPerishabilityFoodThenWarehouseAdd() {
        ControlQuality cQ = new ControlQuality();
        Food apple = new Apple("apple", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  4, 1), 122);
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
        Store store = new Warehouse();
        assertThat(cQ.controlProducts(store, foods).size()).isEqualTo(2);
        assertThat(cQ.controlProducts(store, foods)).contains(sugar, tea);
    }
}