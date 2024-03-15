package ru.job4j.ood.lsp.parking;

public class App {
    public static void main(String[] args) {
        AutoParking p = new AutoParking(2, 2);
        Auto a = new Truck(2);
        Auto b = new Truck(2);
        p.addAuto(a);
        p.addAuto(b);
        p.addAuto(new Truck(2));
        for (Auto c : p.findAll()) {
            System.out.println(c.getSize());
        }
        System.out.println("car = " + p.getSizeCarParking());
        System.out.println("truc = " + p.getSizeTruckParking());
        System.out.println(p.freeParkingSpaces());
    }
}
