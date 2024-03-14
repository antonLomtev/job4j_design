package ru.job4j.ood.lsp.product;

import java.time.LocalDate;

public class Sugar extends Food {
    public Sugar(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        super(name, expiryDate, createDate, price);
    }
}
