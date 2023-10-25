package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    @DisplayName("Количество цифр в числе")
    void countOfValues() {
        final int INPUT = 544;
        final int EXPECTED_COUNT_DIGITS = 3;

        int countsOfDigits = Task2.countDigits(INPUT);

        assertEquals(EXPECTED_COUNT_DIGITS, countsOfDigits);
    }

    @Test
    @DisplayName("Проверка 2, на количество цифр в числе")
    void countOfValues2() {
        final int INPUT = 4666;
        final int EXPECTED_COUNT_DIGITS = 4;

        int countDigits = Task2.countDigits(INPUT);

        assertEquals(EXPECTED_COUNT_DIGITS, countDigits);
    }

    @Test
    @DisplayName("Проверка нуля на количество цифр")
    void countOfValuesByZero() {
        final int INPUT = 0;
        final int EXPECTED_COUNT_DIGITS = 1;

        int countOfDigits = Task2.countDigits(INPUT);

        assertEquals(EXPECTED_COUNT_DIGITS, countOfDigits);
    }

    @Test
    @DisplayName("Проверка на большом числе")
    void countOfValuesALot() {
        final int INPUT = 1212121;
        final int EXPECTED_COUNT_DIGITS = 7;

        int countOfDigits = Task2.countDigits(INPUT);

        assertEquals(EXPECTED_COUNT_DIGITS, countOfDigits);
    }


}
