package ru.job4j.ood.isp;

public class Line implements Shape {
    @Override
    public void drawLine() {
        System.out.println("Draw Line");
    }

    @Override
    public void drawCircle() {
    }

    @Override
    public void drawRect() {
    }
}
