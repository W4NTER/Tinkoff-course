package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    @Test
    @DisplayName("Количество чисел в числе")
    void countOfValues() {
        int input = 544;

        int countsOfDigits = Task2.countDigits(input);

        assertEquals(3, countsOfDigits);
    }

    @Test
    @DisplayName("Тест2")
    void countOfValues2() {
        int input = 4666;

        int countDigits = Task2.countDigits(input);

        assertEquals(4, countDigits);
    }

    @Test
    @DisplayName("Тест3")
    void countOfValuesByZero() {
        int input = 0;

        int countOfDigits = Task2.countDigits(input);

        assertEquals(1, countOfDigits);
    }

    @Test
    @DisplayName("Тест4")
    void countOfValuesALot() {
        int input = 1212121;

        int countOfDigits = Task2.countDigits(input);

        assertEquals(7, countOfDigits);
    }


}
