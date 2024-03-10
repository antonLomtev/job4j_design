package ru.job4j.ood.srp.formatter;

import ru.job4j.ood.srp.model.Employee;

public interface FormatEmployee<T> {
    T getEmployee(Employee employee);
}
