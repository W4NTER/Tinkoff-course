package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Проверка регулярных выражений")
    void testThatDoRegularExpressionsWork() {
        final String[] STRINGS_TO_TEST = {
            "11011",
            "110",
            "01010",
            "111",
            "10101",
            "010000000",
            "10010101000001"
        };

        assertTrue(Task8.regularExpressions(1, STRINGS_TO_TEST[0]));
        assertFalse(Task8.regularExpressions(2, STRINGS_TO_TEST[1]));
        assertTrue(Task8.regularExpressions(3, STRINGS_TO_TEST[2]));
        assertFalse(Task8.regularExpressions(4, STRINGS_TO_TEST[3]));
        assertTrue(Task8.regularExpressions(5, STRINGS_TO_TEST[4]));
        assertTrue(Task8.regularExpressions(6, STRINGS_TO_TEST[5]));
        assertTrue(Task8.regularExpressions(7, STRINGS_TO_TEST[6]));
    }
}
