package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
class HRReportTest {
    @Test
    public void whenHRReportDescendingGenerate() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 150);
        Employee worker1 = new Employee("Kuzya", now, now, 100);
        Employee worker2 = new Employee("Kirill", now, now, 200);
        Employee worker3 = new Employee("Vasya", now, now, 137);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HRReport(store);
        StringBuilder expected = new StringBuilder()
                .append("Kirill - 200.0" + System.lineSeparator())
                .append("Ivan - 150.0" + System.lineSeparator())
                .append("Vasya - 137.0" + System.lineSeparator())
                .append("Kuzya - 100.0" + System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}