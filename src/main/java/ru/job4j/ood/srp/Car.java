package ru.job4j.ood.srp;

public class Car {
    private String type;
    private String number;
    private User userCar;

    public Car(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUserCar() {
        return userCar;
    }

    public void setUserCar(User userCar) {
        this.userCar = userCar;
    }
}
