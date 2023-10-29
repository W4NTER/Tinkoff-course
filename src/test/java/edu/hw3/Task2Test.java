package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Task2Test {
    @Test
    @DisplayName("проверка метода кластеризации")
    void clusterizeTest() {
        final String input = "((())())(()(()()))";
        final String[] result = { "((())())", "(()(()()))" };

        assertArrayEquals(result, Task2.clusterize(input));
    }
}
