package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SimpleSetTest {
    @Test
    void when4AddAndAddFirstThenFalse() {
        SimpleSet simpleSet = new SimpleSet();
        simpleSet.add("first");
        simpleSet.add("second");
        simpleSet.add("third");
        simpleSet.add("four");
        assertThat(simpleSet.add("first")).isFalse();
    }
}