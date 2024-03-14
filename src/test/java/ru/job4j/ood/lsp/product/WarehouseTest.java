package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    void whenAddWarehouse() {
        Food milk = new Milk("milk", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  3, 10), 100);
        Food sugar = new Sugar("sugar", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  12, 10), 100);
        Store store = new Warehouse();
        store.add(milk);
        store.add(sugar);
        assertThat(store.findAll().size()).isEqualTo(1);
        assertThat(store.findAll().get(0)).isEqualTo(sugar);
    }
}