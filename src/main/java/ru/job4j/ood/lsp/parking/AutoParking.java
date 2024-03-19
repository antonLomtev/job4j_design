package ru.job4j.ood.lsp.parking;

import java.util.List;

public class AutoParking implements Parking {

    private int countParkingSpacesCar;
    private int countParkingSpacesTruck;
    private int sizeCarParking;
    private int sizeTruckParking;
    private List<Auto> carParking;
    private List<Auto> truckParking;

    public AutoParking(int sizeCarParking, int sizeTruckParking) {
        this.sizeCarParking = sizeCarParking;
        this.sizeTruckParking = sizeTruckParking;
    }

    @Override
    public void addAuto(Auto auto) {

    }

    @Override
    public List<Auto> findAll() {
        return null;
    }

    @Override
    public int countFreeParkingSpaces() {
        return 0;
    }

    public int getSizeCarParking() {
        return sizeCarParking;
    }

    public int getSizeTruckParking() {
        return sizeTruckParking;
    }
}
