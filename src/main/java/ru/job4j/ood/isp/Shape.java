package ru.job4j.ood.isp;

public interface Shape {

    /**
     * Каждому классу придется реализовывать эти методы, хоть они этого и не делают
     */
    void drawLine();

    void drawCircle();

    void drawRect();
}
