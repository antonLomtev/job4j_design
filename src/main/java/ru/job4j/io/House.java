package ru.job4j.io;

import java.util.Arrays;

public class House {
    private final boolean isBrick;
    private final int yearOfConstruction;
    private final String company;

    private final Integer[] entrance;
    private final Address address;

    public House(boolean isBrick, int yearOfConstruction, String company, Integer[] entrance, Address address) {
        this.isBrick = isBrick;
        this.yearOfConstruction = yearOfConstruction;
        this.company = company;
        this.entrance = entrance;
        this.address = address;
    }

    public boolean isBrick() {
        return isBrick;
    }

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public String getCompany() {
        return company;
    }

    public Integer[] getEntrance() {
        return entrance;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "House{"
                +
                "isBrick=" + isBrick
                +
                ", yearOfConstruction=" + yearOfConstruction
                + ", company='" + company + '\''
                + ", entrance=" + Arrays.toString(entrance)
                + ", address=" + address + '}';
    }
}
