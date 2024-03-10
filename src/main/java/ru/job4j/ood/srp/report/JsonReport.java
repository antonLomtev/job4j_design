package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.FormatEmployee;
import ru.job4j.ood.srp.formatter.XmlJsonEmployee;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.XJEmployee;
import ru.job4j.ood.srp.store.Store;

import java.util.*;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private final Store store;
    private final DateTimeParser dateTimeParser;
    private final Gson json;

    public JsonReport(Store store, DateTimeParser dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.json = new GsonBuilder().create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<XJEmployee> employees = new ArrayList<>();
        for (Employee e : store.findBy(filter)) {
            XmlJsonEmployee xmE = new XmlJsonEmployee();
            employees.add(xmE.getEmployee(e));
        }
        return json.toJson(employees);
    }
}
