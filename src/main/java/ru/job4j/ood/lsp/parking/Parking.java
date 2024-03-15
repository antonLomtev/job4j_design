package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {
    boolean freeParkingSpaces();

    void addAuto(Auto auto);

    List<Auto> findAll();
}
