package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class GeneratorTest {

    @Test
    void whenNamePetrSubjectYouThenPetrYou() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        String expected = "I am a Petr, Who are You? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "You");
        assertThat(generator.produce(template, args)).isEqualTo(expected);
    }

    @Test
    void whenSubjectIsMissingThenGetException() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenNameIsMissingThenGetException() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("subject", "You");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenRedundantKeyThenGetException() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "You");
        args.put("lastName", "Arsentev");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}