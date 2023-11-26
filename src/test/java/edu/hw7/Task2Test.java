package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Проверка правильности факториала")
    void testThatFactorialCheckReturnedSucceed() {
        final int NUMBER = 16;

        final long EXPECTED_VALUE = 20922789888000L;

        long result = Task2.factorial(16);

        assertEquals(EXPECTED_VALUE, result);
    }
}
