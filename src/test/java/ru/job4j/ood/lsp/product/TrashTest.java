package ru.job4j.ood.lsp.product;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class TrashTest {
    @Test
    void whenAddTrash() {
        Food apple = new Apple("apple", LocalDate.of(2024, 3, 1), LocalDate.of(2024,  4, 1), 122);
        Food bread = new Bread("bread", LocalDate.of(2024, 3, 10), LocalDate.of(2024,  3, 14), 40);
        Store store = new Trash();
        store.add(apple);
        store.add(bread);
        assertThat(store.findAll().size()).isEqualTo(1);
        assertThat(store.findAll().get(0)).isEqualTo(bread);
    }
}