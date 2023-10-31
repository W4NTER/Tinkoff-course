package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.attribute.FileAttribute;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {

    @Test
    @DisplayName("Проверка на полиндром числа 122")
    void isThisPalindrome(){
        final int NUMBER = 122;

        assertFalse(Task5.isPalindromeDescendant(NUMBER));

    }

    @Test
    @DisplayName("Обрабатывается ли случай с числом длины 1")
    void lengthOne() {
        final int NUMBER = 9;

        assertFalse(Task5.isPalindromeDescendant(NUMBER));
    }

    @Test
    @DisplayName("Проверка на полиндром числа 11211230")
    void isThisPalindrome1(){
        final int NUMBER = 11211230;

        assertTrue(Task5.isPalindromeDescendant(NUMBER));
    }

    @Test
    @DisplayName("Проверка на полиндром числа 23336014")
    void isThisPalindrome2(){
        final int NUMBER = 23336014;

        assertTrue(Task5.isPalindromeDescendant(NUMBER));
    }

    @Test
    @DisplayName("Проверка на полиндром числа 12991")
    void isThisPalindrome3(){
        final int NUMBER = 12991;

        assertFalse(Task5.isPalindromeDescendant(NUMBER));
    }
}
