package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    @DisplayName("Провека находится ли подстрока в строке")
    void testThatIsThisSubstringReturnedSucceed() {
        final String STRING_TEST = "achfdbaabgabcaabg";
        final String SUBSTRING_TEST = "abc";
        final String SUBSTRING2_TEST = "bsbs";

        assertTrue(Task6.substringByRegularExpression(STRING_TEST, SUBSTRING_TEST));
        assertFalse(Task6.substringByRegularExpression(STRING_TEST, SUBSTRING2_TEST));
    }
}
