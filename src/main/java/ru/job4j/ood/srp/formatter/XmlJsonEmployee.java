package ru.job4j.ood.srp.formatter;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.XJEmployee;

public class XmlJsonEmployee implements FormatEmployee<XJEmployee> {
    private final DateTimeParser parser = new ReportDateTimeParser();

    @Override
    public XJEmployee getEmployee(Employee employee) {
        return new XJEmployee(employee.getName(), parser.parse(employee.getHired()), parser.parse(employee.getFired()), employee.getSalary());
    }
}
