package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Проверка корректности работы счетчика")
    void testThatIncrementCounterBySomeThreadsReturnedSucceed() {
        final int COUNT_THREADS = 10;
        final int NUM = 12;

        Task1.numerator(COUNT_THREADS, NUM);

        final int EXPECTED_VALUE = 120;
        assertEquals(EXPECTED_VALUE, Task1.getCounter().get());
    }
}
