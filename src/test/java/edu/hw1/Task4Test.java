package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    @Test
    @DisplayName("Изменение порядка символов")
    void fixedString() {
        String input = "123456";

        String result = "214365";


        assertEquals(result, Task4.fixString(input));

    }

    @Test
    @DisplayName("Test2")
    void fixedString1() {
        String input = "hTsii  s aimex dpus rtni.g";

        String result = "This is a mixed up string.";

        assertEquals(result, Task4.fixString(input));

    }

    @Test
    @DisplayName("Test3")
    void fixedString2() {
        String input = "badce";

        String result = "abcde";

        assertEquals(result, Task4.fixString(input));
    }

    @Test
    @DisplayName("Test4")
    void fixedString13() {
        String input = "оПомигети псаривьтс ртко!и";

        String result = "Помогите исправить строки!";

        assertEquals(result, Task4.fixString(input));
    }
}
