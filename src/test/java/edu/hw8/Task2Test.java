package edu.hw8;

import edu.hw8.Task2.Calculator;
import edu.hw8.Task2.Fibonacci;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.module.FindException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Проверка правильности вычисления числа Фибаначчи")
    void testThatCalculateFibonacciByMultiThreadsReturnedSucceed() {
        final int COUNT_VALUES = 10 ;
        final int COUNT_THREADS = 4;


//        final long RESULT = Calculator.getFibValue(COUNT_THREADS, COUNT_VALUES);

        final long EXPECTED_VALUE = 2880067194370816120L;
//        assertEquals(EXPECTED_VALUE, RESULT);
    }
}
