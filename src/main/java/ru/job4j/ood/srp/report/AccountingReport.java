package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class AccountingReport implements Report {
    private final CurrencyConverter converter;
    private final Store store;
    private final Currency currency;

    private final Currency targetCurrency;

    public AccountingReport(CurrencyConverter converter, Store store, Currency currency, Currency targetCurrency) {
        this.converter = converter;
        this.store = store;
        this.currency = currency;
        this.targetCurrency = targetCurrency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            double convertSalary = converter.convert(currency, employee.getSalary(), targetCurrency);
            text.append(employee.getName() + " - " + employee.getSalary() + " " + currency
                    + " in " + targetCurrency + " = " + convertSalary + System.lineSeparator());
        }
        return text.toString();
    }
}
