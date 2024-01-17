package edu.hw8;

import edu.hw8.Task2.Fibonacci;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Проверка правильности вычисления числа Фибаначчи")
    void testThatCalculateFibonacciByMultiThreadsReturnedSucceed() {
        final int COUNT_VALUES = 83;
        final int COUNT_THREADS = 4;


        final long RESULT = Fibonacci.getFibValue(COUNT_THREADS, COUNT_VALUES);

        final long EXPECTED_VALUE = 99194853094755497L;
        assertEquals(EXPECTED_VALUE, RESULT);
    }
}
