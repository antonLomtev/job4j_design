package ru.job4j.kiss.fool;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class FoolTest {
    @Test
    void whenFizzBuzz() {
        assertThat(Fool.check(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void whenBuzz() {
        assertThat(Fool.check(5)).isEqualTo("Buzz");
    }

    @Test
    void whenFizz() {
        assertThat(Fool.check(12)).isEqualTo("Fizz");
    }
}