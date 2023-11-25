package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "two", "three", "four", "five", "s");
        assertThat(list).hasSize(6)
                .contains("two")
                .contains("s", Index.atIndex(5))
                .containsAnyOf("e", "one", "eleven")
                .doesNotContain("four", Index.atIndex(2))
                .isNotEmpty();
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> strings = simpleConvert.toSet("one", "second", "three", "four", "five", "seven");
        assertThat(strings).isNotEmpty()
                .hasSize(6)
                .contains("seven")
                .contains("one")
                .doesNotContain("two");
        assertThat(strings).first().isEqualTo("four");
        assertThat(strings).element(0).isNotNull()
                .isEqualTo("four");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> stringMap = simpleConvert.toMap("one", "two", "second", "four", "seven", "eit");
        assertThat(stringMap).isNotEmpty()
                .hasSize(6)
                .containsKey("one")
                .containsEntry("two", 1);
    }
}