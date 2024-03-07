package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
class AccountingReportTest {
    @Test
    public void whenAccountingReportGeneratedRubUsd() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Kolya", now, now, 2000);
        CurrencyConverter cc = new InMemoryCurrencyConverter();
        store.add(worker);
        store.add(worker1);
        Report engine = new AccountingReport(cc, store, Currency.RUB, Currency.USD);
        String expected = "Ivan - 100.0 RUB in USD = 1.6199999999999999" + System.lineSeparator()
                         + "Kolya - 2000.0 RUB in USD = 32.4" + System.lineSeparator();
        assertThat(engine.generate(employee -> true)).isEqualTo(expected);
    }

    @Test
    public void whenAccountingReportGeneratedRubEur() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Kolya", now, now, 2000);
        CurrencyConverter cc = new InMemoryCurrencyConverter();
        store.add(worker);
        store.add(worker1);
        Report engine = new AccountingReport(cc, store, Currency.RUB, Currency.EUR);
        String expected = "Ivan - 100.0 RUB in EUR = 1.66" + System.lineSeparator()
                + "Kolya - 2000.0 RUB in EUR = 33.2" + System.lineSeparator();
        assertThat(engine.generate(employee -> true)).isEqualTo(expected);
    }
}