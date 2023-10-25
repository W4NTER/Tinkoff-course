package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    @DisplayName("Может ли массив вложиться в другой массив")
    void isThisArrFits() {

        int[]array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {2, 5};

        boolean isNestable = Task3.isNestable(array1, array2);

        assertEquals(false, isNestable);
    }

    @Test
    @DisplayName("Test2")
    void isThisArrFits1() {

        int[]array1 = new int[] {1, 2, 3, 4};
        int[] array2 = new int[] {0, 6};

        boolean isNestable = Task3.isNestable(array1, array2);

        assertEquals(true, isNestable);
    }

    @Test
    @DisplayName("Test3")
    void isThisArrFits2() {

        int[]array1 = new int[] {3, 1};
        int[] array2 = new int[] {4, 0};

        boolean isNestable = Task3.isNestable(array1, array2);

        assertEquals(true, isNestable);
    }

    @Test
    @DisplayName("Test4")
    void isThisArrFits3() {

        int[]array1 = new int[] {9, 9, 8};
        int[] array2 = new int[] {8, 9};

        boolean isNestable = Task3.isNestable(array1, array2);

        assertEquals(false, isNestable);
    }
}
