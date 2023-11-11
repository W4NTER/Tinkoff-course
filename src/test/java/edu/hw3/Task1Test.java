package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Проверка на одном из примеров")
    void isThisWorking() {
        final String INPUT = "Hello world!";
        final String EXPECTED_OUTPUT = "Svool dliow!";

        assertEquals(EXPECTED_OUTPUT, Task1.atbash(INPUT));
    }

    @Test
    @DisplayName("Проверка сторонних символов")
    void testSymbols() {
        final String INPUT = "{]/123";
        final String EXPECTED_OUTPUT = "{]/123";

        assertEquals(EXPECTED_OUTPUT, Task1.atbash(INPUT));
    }

    @Test
    @DisplayName("Проверка больших букв")
    void testUpperCase() {
        final String INPUT = "SAY";
        final String EXPECTED_OUTPUT = "HZB";

        assertEquals(EXPECTED_OUTPUT, Task1.atbash(INPUT));
    }
}
