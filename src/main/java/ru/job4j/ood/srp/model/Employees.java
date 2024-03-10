package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {

    List<XJEmployee> employee;

    public Employees() {
    }

    public Employees(List<XJEmployee> employees) {
        this.employee = employees;
    }

    public List<XJEmployee> getEmployees() {
        return employee;
    }

    public void setEmployees(List<XJEmployee> employees) {
        this.employee = employees;
    }
}
