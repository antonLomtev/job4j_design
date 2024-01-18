package ru.job4j.io;

public class Address {
    private final String street;
    private final int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{"
                + "street='" + street + '\''
                + ", number=" + number + '}';
    }
}
