package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.FormatEmployee;
import ru.job4j.ood.srp.formatter.XmlJsonEmployee;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.model.XJEmployee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class XmlReport implements Report {
    private final Store store;
    private final DateTimeParser parser;
    private final JAXBContext context;
    private final Marshaller marshaller;

    public XmlReport(Store store, DateTimeParser parser) throws JAXBException {
        this.store = store;
        this.parser = parser;
        context = JAXBContext.newInstance(Employees.class);
        marshaller = context.createMarshaller();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        List<XJEmployee> list = new ArrayList<>();
        for (Employee e : store.findBy(filter)) {
            FormatEmployee<XJEmployee> fe = new XmlJsonEmployee();
            list.add(fe.getEmployee(e));
        }
        try {
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new Employees(list), writer);
                xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
