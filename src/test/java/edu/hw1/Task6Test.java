package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    private final static int FIRST_VALUE = 6621;
    private final static int SECOND_VALUE = 6554;
    private final static int THIRD_VALUE = 1234;

    @Test
    @DisplayName("Проверка правильности результата")
    void countKTest() {
        int result = 5;

         assertEquals(result, Task6.countK(FIRST_VALUE));
    }

    @Test
    @DisplayName("Проверка на другом числе")
    void countKTest2() {
        int result = 4;

        assertEquals(result, Task6.countK(SECOND_VALUE));
    }

    @Test
    @DisplayName("Проверка на третьем числе")
    void countKTest3() {
        int result = 3;

        assertEquals(result, Task6.countK(THIRD_VALUE));
    }
}
