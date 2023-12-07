package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Проверка правильности рассчета и вывода среднего времени в клубе")
    void testThatFindAverageTimeInClubWithTwoInputStringsReturnedSucceed() throws ParseException {
        final String[] STRINGS_FOR_TEST =
            {"2022-04-01, 21:30 - 2022-04-02, 01:23", "2022-03-12, 20:20 - 2022-03-12, 23:50"};

        String result = Task1.averageTimeInTheClub(STRINGS_FOR_TEST);

        final String EXPECTED_VALUE = "3ч 41м 30с";
        assertEquals(EXPECTED_VALUE, result);
    }
}
