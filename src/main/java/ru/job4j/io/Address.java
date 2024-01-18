package ru.job4j.io;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "address")
public class Address {
    @XmlAttribute
    private String street;

    @XmlAttribute
    private int number;

    public Address() {
    }

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Address{"
                + "street='" + street + '\''
                + ", number=" + number + '}';
    }

    public static void main(String[] args) {
        JSONObject jsonAddress = new JSONObject("{\"street\": \"Kosmonavtov\","
                                                     + "\"number\": 50}");
        JSONArray jsonArray1 = new JSONArray(new Integer[]{1, 2, 3, 4, 5});
        final House house = new House(true, 1992, "Stabilnost",
                new Integer[]{1, 2, 3, 4, 5}, new Address("Kosmonavtov", 50));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isBrick", house.isBrick());
        jsonObject.put("yearOfConstruction", house.getYearOfConstruction());
        jsonObject.put("company", house.getCompany());
        jsonObject.put("entrance", jsonArray1);
        jsonObject.put("address", jsonAddress);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(house).toString());
    }
}
