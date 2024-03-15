package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class AutoParking implements Parking {
    private int countParkingSpacesCar;
    private int countParkingSpacesTruck;
    private int sizeCarParking;
    private int sizeTruckParking;
    private List<Auto> carParking;
    private List<Auto> truckParking;

    public AutoParking(int countParkingSpacesCar, int countParkingSpacesTruck) {
        this.countParkingSpacesCar = countParkingSpacesCar;
        this.countParkingSpacesTruck = countParkingSpacesTruck;
        carParking = new ArrayList<>();
        truckParking = new ArrayList<>();
        sizeCarParking = 0;
        sizeTruckParking = 0;
    }

    public int getCountParkingSpacesCar() {
        return countParkingSpacesCar;
    }

    public int getCountParkingSpacesTruck() {
        return countParkingSpacesTruck;
    }

    @Override
    public boolean freeParkingSpaces() {
        return sizeCarParking + sizeTruckParking < countParkingSpacesCar + countParkingSpacesTruck;
    }

    @Override
    public void addAuto(Auto auto) {
        if (freeParkingSpaces()) {
            if (auto.getSize() == 1 && carParking.size() < countParkingSpacesCar) {
                carParking.add(auto);
                sizeCarParking++;
            } else if (auto.getSize() > 1 && sizeTruckParking + auto.getSize() <= countParkingSpacesTruck) {
                truckParking.add(auto);
                sizeTruckParking += auto.getSize();
            } else if (auto.getSize() > 1 && sizeCarParking + auto.getSize() <= countParkingSpacesCar) {
                carParking.add(auto);
                sizeCarParking += auto.getSize();
            }
        }
    }

    public int getSizeCarParking() {
        return sizeCarParking;
    }

    public int getSizeTruckParking() {
        return sizeTruckParking;
    }

    public List<Auto> getCarParking() {
        return carParking;
    }

    public List<Auto> getTruckParking() {
        return truckParking;
    }

    @Override
    public List<Auto> findAll() {
        List<Auto> autos = new ArrayList<>();
        if (!carParking.isEmpty()) {
            for (Auto a : carParking) {
                autos.add(a);
            }
        }
        if (!truckParking.isEmpty()) {
            for (Auto a : truckParking) {
                autos.add(a);
            }
        }
        return autos;
    }
}
