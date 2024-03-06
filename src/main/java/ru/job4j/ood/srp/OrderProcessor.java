package ru.job4j.ood.srp;

public class OrderProcessor {

    private boolean save(Order order) {
        return true;
    }

    private void sendInformationOrder(Order order) {
        System.out.println("Заказ" + order.getName() + "на email: " + order.getEmail());
    }
}
