package ru.job4j.ood.ocp;

public class Order {
    public void saveOrder(String order) {
        System.out.println("save order to DB");
    }
    //если нужно будет заказы сохранять в другие места, нам придется переписывать метод, добавлять проверки
}
