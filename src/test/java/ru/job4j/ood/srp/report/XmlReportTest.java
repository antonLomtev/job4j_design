package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class XmlReportTest {
    @Test
    public void whenXmlReportGenerate() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Kolya", now, now, 2000);
        store.add(worker);
        store.add(worker1);
        Report engine = new XmlReport(store, parser);
        String expected = String.format("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employee>\n"
                + "        <name>Ivan</name>\n"
                + "        <hired>%s</hired>\n"
                + "        <fired>%s</fired>\n"
                + "        <salary>100.0</salary>\n"
                + "    </employee>\n"
                + "    <employee>\n"
                + "        <name>Kolya</name>\n"
                + "        <hired>%s</hired>\n"
                + "        <fired>%s</fired>\n"
                + "        <salary>2000.0</salary>\n"
                + "    </employee>\n"
                + "</employees>\n", parser.parse(now), parser.parse(now), parser.parse(now), parser.parse(now));
        assertThat(engine.generate(employee -> true)).isEqualTo(expected);
    }
}