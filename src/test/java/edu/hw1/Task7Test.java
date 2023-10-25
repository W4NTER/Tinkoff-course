package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {

    @Test
    @DisplayName("проверка rotateLeft1")
    void rotateLeftCheck() {
        int n = 16;
        int shift = 1;

        int result = 1;

        assertEquals(result, Task7.rotateLeft(n, shift));

    }

    @Test
    @DisplayName("проверка rotateLeft2")
    void rotateLeftCheck2() {
        final int n = 17;
        final int shift = 2;
        final int result = 6;

        assertEquals(result, Task7.rotateLeft(n, shift));

    }

    @Test
    @DisplayName("проверка rotateRight")
    void rotateRightCheck() {
        int n = 8;
        int shift = 1;

        int result = 4;

        assertEquals(result, Task7.rotateRight(n, shift));
    }
}
