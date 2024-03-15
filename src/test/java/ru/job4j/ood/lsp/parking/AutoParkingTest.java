package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AutoParkingTest {
    @Test
    void whenAddCarToParkingThenSize1() {
        AutoParking parking = new AutoParking(2, 2);
        Auto car = new Car(1);
        parking.addAuto(car);
        assertThat(parking.findAll().size()).isEqualTo(1);
        assertThat(parking.findAll()).contains(car);
        assertThat(parking.getSizeCarParking()).isEqualTo(1);
        assertThat(parking.getSizeTruckParking()).isEqualTo(0);
    }

    @Test
    void whenAddTruckToParkingThenSize1() {
        AutoParking parking = new AutoParking(2, 2);
        Auto truck = new Truck(2);
        parking.addAuto(truck);
        assertThat(parking.findAll().size()).isEqualTo(1);
        assertThat(parking.findAll()).contains(truck);
        assertThat(parking.getSizeCarParking()).isEqualTo(0);
        assertThat(parking.getSizeTruckParking()).isEqualTo(2);
    }

    @Test
    void whenAddTruckToParkingFullTruckThenCarParking2() {
        AutoParking parking = new AutoParking(2, 2);
        Auto truck = new Truck(2);
        Auto truck1 = new Truck(2);
        parking.addAuto(truck);
        parking.addAuto(truck1);
        assertThat(parking.findAll().size()).isEqualTo(2);
        assertThat(parking.findAll()).contains(truck, truck1);
        assertThat(parking.getSizeCarParking()).isEqualTo(2);
        assertThat(parking.getSizeTruckParking()).isEqualTo(2);
    }
}