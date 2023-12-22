package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Проверка нахождения пятниц 13 числа в году")
    void testThatFindFridays13thInTheYearReturnedSucceed() {
        final int TEST_YEAR = 2024;

        List<LocalDate> result = Task2.findFridays13InTheYear(TEST_YEAR);

        final List<LocalDate> EXPECTED_VALUE = List.of(LocalDate.of(2024, Month.SEPTEMBER, 13),
            LocalDate.of(2024, Month.DECEMBER, 13));
        assertEquals(EXPECTED_VALUE, result);
    }

    @Test
    @DisplayName("Проверка нахождения следующей пятницы 13")
    void testThatFindNextFriday13thReturnedSucceed() {
        final LocalDate TEST_DATE = LocalDate.of(2024, Month.NOVEMBER, 11);

        LocalDate result = Task2.findNextFriday13th(TEST_DATE);

        final LocalDate EXPECTED_VALUE = LocalDate.of(2024, Month.DECEMBER, 13);
        assertEquals(EXPECTED_VALUE, result);
    }
}
