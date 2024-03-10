package ru.job4j.ood.ocp;

public class Shop {
    public String getPrice(String product) {
        String p = "";
            if ("Bread".equals(product)) {
                p = "40";
            } else if ("Milk".equals(product)) {
                p = "100";
        }
            return p;
    }
    /**
     * тут в зависимости от продукта возвращаем цены, ну когда количество продуктов разрастется
     * нужно будет огромное количество проверок, а если еще буду скидки будет тяжело отслеживать все изменения
     */
}
