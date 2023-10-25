package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    @Test
    @DisplayName("Test4")
    void isThisPalindrome(){

        int number = 122;

        assertEquals(false, Task5.isPalindromeDescendant(number));

    }

    @Test
    @DisplayName("Обрабатывается ли случай с числом длины 1")
    void lengthOne() {
        assertEquals(false, Task5.isPalindromeDescendant(1));
    }

    @Test
    @DisplayName("Test1")
    void isThisPalindrome1(){

        int number = 11211230;

        assertEquals(true, Task5.isPalindromeDescendant(number));
    }

    @Test
    @DisplayName("Test2")
    void isThisPalindrome2(){

        int number = 23336014;

        assertEquals(true, Task5.isPalindromeDescendant(number));
    }

    @Test
    @DisplayName("Test3")
    void isThisPalindrome3(){

        int number = 12991;

        assertEquals(false, Task5.isPalindromeDescendant(number));
    }
}
