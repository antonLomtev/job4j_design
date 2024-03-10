package ru.job4j.ood.ocp;

public class Payment {

    public void payment(String payType) {
        if ("Card".equals(payType)) {
            System.out.println("Card");
        } else if ("QuarCode".equals(payType)) {
            System.out.println("Quar");
        }
        /**
         * если нужно будет добавлять другие типы оплаты, например наличка и придется изменять метод
         */
    }
}
