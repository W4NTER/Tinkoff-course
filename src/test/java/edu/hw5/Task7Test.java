package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    @DisplayName("Проверка правильности работы регулярок")
    void testThatCheckRegularExpressionsReturnedSucceed() {
        final String[] STRINGS_TO_TEST = {
            "11012",
            "110",
            "101",
            "10101",
            "000",
            "010100001010101010",
            "10",
            "1001"
        };

        assertFalse(Task7.stringChecking(1, STRINGS_TO_TEST[0]));
        assertTrue(Task7.stringChecking(1, STRINGS_TO_TEST[1]));
        assertFalse(Task7.stringChecking(1, STRINGS_TO_TEST[2]));
        assertTrue(Task7.stringChecking(2, STRINGS_TO_TEST[3]));
        assertTrue(Task7.stringChecking(2, STRINGS_TO_TEST[4]));
        assertTrue(Task7.stringChecking(2, STRINGS_TO_TEST[5]));
        assertTrue(Task7.stringChecking(3, STRINGS_TO_TEST[6]));
        assertFalse(Task7.stringChecking(3, STRINGS_TO_TEST[7]));
    }
}
