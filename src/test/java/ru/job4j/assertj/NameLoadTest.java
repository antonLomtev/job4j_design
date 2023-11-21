package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkNameLength0() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkContainsSymbolEquals() {
        NameLoad nameLoad = new NameLoad();
        String test = "test test";
        assertThatThrownBy(() -> nameLoad.parse(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(test)
                .hasMessageContaining("does not contain the symbol '='")
                .hasMessageContaining(test);
    }

    @Test
    void checkContainsNoValue() {
        NameLoad nameLoad = new NameLoad();
        String test = "test=";
        assertThatThrownBy(() -> nameLoad.parse(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(test)
                .hasMessageContaining("does not contain a value")
                .hasMessageContaining(test);
    }

    @Test
    void checkOnlySymbolEquals() {
        NameLoad nameLoad = new NameLoad();
        String test = "=";
        assertThatThrownBy(() -> nameLoad.parse(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(test)
                .hasMessageContaining("does not contain a value")
                .hasMessageContaining(test);
    }
}