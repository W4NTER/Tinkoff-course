package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    @DisplayName("Проверка на содержание целевых символов")
    void testThatRegularExpressionCheckReturnedSucceed() {
        final String password1 = "asasa~s";
        final String password2 = "asas";

        boolean res1 = Task4.regularExpressionForThePassword(password1);
        boolean res2 = Task4.regularExpressionForThePassword(password2);

        assertTrue(res1);
        assertFalse(res2);
    }
}
