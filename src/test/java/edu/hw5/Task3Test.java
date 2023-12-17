package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Проверка парсера дат")
    void testThatParseDateCheckReturnedSucceed() {
        final String[] PATTERNS = {
            "2020-10-10",
            "2020-12-2",
            "1/3/1976",
            "1/3/20",
            "tomorrow",
            "today",
            "yesterday",
            "1 day ago",
            "2234 days ago"
        };

        final List<Optional<LocalDate>> EXPECTED_RESULT = List.of (
          Optional.of(LocalDate.of(2020, Month.OCTOBER, 10)),
          Optional.of(LocalDate.of(2020, Month.DECEMBER, 2)),
          Optional.of(LocalDate.of(1976, Month.JANUARY, 3)),
          Optional.of(LocalDate.of(2020, Month.JANUARY, 3)),
          Optional.of(LocalDate.now().plusDays(1)),
          Optional.of(LocalDate.now()),
          Optional.of(LocalDate.now().minusDays(1)),
          Optional.of(LocalDate.now().minusDays(1)),
          Optional.of(LocalDate.now().minusDays(2234))
        );

        assertEquals(EXPECTED_RESULT.get(0), Task3.parseDate(PATTERNS[0]));
        assertEquals(EXPECTED_RESULT.get(1), Task3.parseDate(PATTERNS[1]));
        assertEquals(EXPECTED_RESULT.get(2), Task3.parseDate(PATTERNS[2]));
        assertEquals(EXPECTED_RESULT.get(3), Task3.parseDate(PATTERNS[3]));
        assertEquals(EXPECTED_RESULT.get(4), Task3.parseDate(PATTERNS[4]));
        assertEquals(EXPECTED_RESULT.get(5), Task3.parseDate(PATTERNS[5]));
        assertEquals(EXPECTED_RESULT.get(6), Task3.parseDate(PATTERNS[6]));
        assertEquals(EXPECTED_RESULT.get(7), Task3.parseDate(PATTERNS[7]));
        assertEquals(EXPECTED_RESULT.get(8), Task3.parseDate(PATTERNS[8]));
    }
}
