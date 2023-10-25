package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {

    @Test
    @DisplayName("Test1")
    void countKTest() {
        int value = 6621;

        int result = 5;

         assertEquals(result, Task6.countK(value));
    }

    @Test
    @DisplayName("Test2")
    void countKTest2() {
        int value = 6554;

        int result = 4;

        assertEquals(result, Task6.countK(value));
    }

    @Test
    @DisplayName("Test3")
    void countKTest3() {
        int value = 1234;

        int result = 3;

        assertEquals(result, Task6.countK(value));
    }
}
