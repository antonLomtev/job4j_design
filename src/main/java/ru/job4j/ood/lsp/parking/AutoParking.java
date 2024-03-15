package ru.job4j.ood.lsp.parking;

import java.util.List;

public class AutoParking implements Parking {
    private int countParkingSpacesCar;
    private int countParkingSpacesTruck;
    private List<Auto> carParking;
    private List<Auto> truckParking;

    public AutoParking(int countParkingSpacesCar, int countParkingSpacesTruck) {
        this.countParkingSpacesCar = countParkingSpacesCar;
        this.countParkingSpacesTruck = countParkingSpacesTruck;
    }

    public int getCountParkingSpacesCar() {
        return countParkingSpacesCar;
    }

    public int getCountParkingSpacesTruck() {
        return countParkingSpacesTruck;
    }

    @Override
    public boolean freeParkingSpaces() {
        return carParking.size() + truckParking.size() < countParkingSpacesCar + countParkingSpacesTruck;
    }

    @Override
    public void addAuto(Auto auto) {

    }

    @Override
    public List<Auto> findAll() {
        return null;
    }
}
