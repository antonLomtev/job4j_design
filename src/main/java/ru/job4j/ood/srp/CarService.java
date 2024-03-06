package ru.job4j.ood.srp;

public class CarService {
    public Car getCarForNumber(String numberCar) {
        return new Car(numberCar);
    }

    public User getUserCar(String numberCar) {
        return new User();
    }

    public void sendMessage(String messageCar) {
        System.out.println(new Car("A161AA11"));
    }
}
