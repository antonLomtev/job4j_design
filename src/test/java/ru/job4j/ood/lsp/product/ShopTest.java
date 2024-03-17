package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    @Test
    void whenAddFoodShop() {
        Store store = new Shop();
        Food apple = new Apple("apple", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  4, 1), 122);
        Food bread = new Bread("bread", LocalDate.of(2024, 3, 10), LocalDate.of(2024,  3, 14), 40);
        store.add(apple);
        store.add(bread);
        assertThat(apple).isEqualTo(store.findAll().get(0));
        assertThat(store.findAll().size()).isEqualTo(1);
    }

    @Test
    void whenAddEndExpirationDateThenPrice80() {
        Food apple = new Apple("apple", LocalDate.of(2024, 3, 1), LocalDate.now().plusDays(2), 100);
        Food bread = new Bread("bread", LocalDate.of(2024, 3, 10), LocalDate.now(), 40);
        Store store = new Shop();
        store.add(apple);
        store.add(bread);
        assertThat(store.findAll().get(0).getPrice()).isEqualTo(80.0);
    }
}