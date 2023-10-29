package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Проверка на конвертации арабских цифр в римские")
    void convertToRomanTest() {
        final String RESULT = "XI";
        final int INPUT = 11;

        assertEquals(RESULT, Task4.convertToRoman(INPUT));
    }

}
