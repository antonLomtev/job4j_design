package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {
    void addAuto(Auto auto);

    List<Auto> findAll();

    int countFreeParkingSpaces();
}
