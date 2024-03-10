package ru.job4j.ood.srp.report;


import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class JsonReportTest {
    @Test
    public void whenJsonReportGenerate() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Kolya", now, now, 2000);
        store.add(worker);
        store.add(worker1);
        Report engine = new JsonReport(store, parser);
        StringBuilder exp = new StringBuilder();
        String ivan = String.format("[{\"name\":\"Ivan\",\"hired\":\"%s\",\"fired\":\"%s\",\"salary\":100.0},",
                parser.parse(now), parser.parse(now));
        String kolya = String.format("{\"name\":\"Kolya\",\"hired\":\"%s\",\"fired\":\"%s\",\"salary\":2000.0}]",
                parser.parse(now), parser.parse(now));
        exp.append(ivan);
        exp.append(kolya);
        assertThat(engine.generate(employee -> true)).isEqualTo(exp.toString());
    }
}