package ru.job4j.ood.dip;

import java.util.List;

public class Services {
    Bd bd = new Bd();
    Order order = new Order();
    AutoPark autoPark = new AutoPark();

    public void save(Person p) {
        bd.save(p);
    }

    public List<Product> products() {
        return order.getProducts();
    }

    public Mazda findMazda(Integer number) {
        return autoPark.getMazdaList().get(0);
    }
}
