package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Проверка TreeMap на использование null")
    void testTreeMapWithNull() {
        TreeMap<String, String> tree = new TreeMap<>(new Task7());
        tree.put(null, "test");
        tree.put("test", null);

        assertThat(tree.containsKey(null)).isTrue();
        assertThat(tree.containsValue(null)).isTrue();
    }
}
