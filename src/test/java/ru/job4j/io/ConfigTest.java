package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.values("name")).isEqualTo("Anton Stogniy");
    }

    @Test
    void whenCommentAndEmptyString() {
        String path = "./data/whenCommentAndEmptyString.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.values("login")).isEqualTo("name");
        assertThatThrownBy(() -> config.values("ForTest")).isInstanceOf(UnsupportedOperationException.class);
        assertThat(config.getValues()).hasSize(1);
    }

    @Test
    void whenIncorrectKey() {
        String path = "./data/incorrectKey.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenIncorrectValue() {
        String path = "./data/incorrectValue.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }
}