package ru.job4j.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HouseGson {
    public static void main(String[] args) {
        final House house = new House(true, 1992, "Stabilnost",
                new Integer[]{1, 2, 3, 4, 5}, new Address("Kosmonavtov", 50));
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(house));
        final String houseJson =
                "{"
                + "\"isBrick\": true,"
                + "\"yearOfConstruction\": 1992,"
                + "\"company\": \"Stabilnost\","
                + "\"entrance\":"
                + "[1,2,3,4,5],"
                + "\"address\":"
                + "{"
                + "\"street\": Kosmonavtov,"
                + "\"number\": 50"
                + "}}";
        final House houseMod = gson.fromJson(houseJson, House.class);
        System.out.println(houseMod + "");
        System.out.println(houseMod.getAddress() + "");
    }
}
