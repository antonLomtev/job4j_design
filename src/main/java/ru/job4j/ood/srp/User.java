package ru.job4j.ood.srp;

public class User {
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public void save(User user) {
        System.out.println(user.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
