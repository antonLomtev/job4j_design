package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 20);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 15);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(5, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void whenEdgeLess0ThenVertexEqLes1() {
        Box box = new Box(0, -10);
        int result = box.getNumberOfVertices();
        int expected = -1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenVertex0ThenVertex0() {
        Box box = new Box(0, 10);
        int result = box.getNumberOfVertices();
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenVertex8ThenVertex8() {
        Box box = new Box(8, 12);
        int result = box.getNumberOfVertices();
        int expected = 8;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenSphereEdge10Then1256() {
        Box box = new Box(0, 10);
        double result = box.getArea();
        double expected = 1256.64;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenCubeEdge15Then1350() {
        Box box = new Box(8, 15);
        double result = box.getArea();
        double expected = 1350;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenVertex0ThenTrue() {
        Box box = new Box(0, 12);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void whenEdgeLess0ThenFalse() {
        Box box = new Box(0, -12);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void whenVertex5ThenFalse() {
        Box box = new Box(5, 15);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }
}