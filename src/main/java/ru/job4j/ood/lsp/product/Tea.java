package ru.job4j.ood.lsp.product;

import java.time.LocalDate;

public class Tea extends Food {
    public Tea(String name, LocalDate expiryDate, LocalDate createDate, double price) {
        super(name, expiryDate, createDate, price);
    }
}
