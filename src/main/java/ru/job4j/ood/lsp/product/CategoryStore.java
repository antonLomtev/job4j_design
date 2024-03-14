package ru.job4j.ood.lsp.product;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CategoryStore {
    public static int getCategoryStore(LocalDate createdDate, LocalDate expiryDate) {
        double percent = expiryPercent(createdDate, expiryDate);
        int category = -1;
        if (percent < 25) {
            category = 0;
        } else if (percent >= 25 && percent < 75) {
            category = 1;
        } else if (percent >= 75 && percent < 100) {
            category = 2;
        } else if (percent >= 100) {
            category = 3;

        }
        return category;
    }

    private static double expiryPercent(LocalDate createDate, LocalDate expiryDate) {
        LocalDate now = LocalDate.now();
        double term = ChronoUnit.DAYS.between(createDate, expiryDate);
        double dayExpiry = ChronoUnit.DAYS.between(createDate, now);
        return (dayExpiry / term) * 100;
    }
}
