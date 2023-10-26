package edu.hw2;

import edu.hw2.Task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {

    @Test
    @DisplayName("Тест класса Constant")
    void constantTest() {
        final int VALUE = 5;
        var num = new Expr.Constant(VALUE);

        assertEquals(VALUE, num.evaluate());
    }

    @Test
    @DisplayName("Тест класса Negate")
    void negateTest() {
        final int VALUE = 7;
        var negNum = new Expr.Negate(VALUE);

        assertEquals(-VALUE, negNum.evaluate());
    }

    @Test
    @DisplayName("Тест класса Exponent (возведение в степень)")
    void exponentTest() {
        final int VALUE = 2;
        final int DEGREE = 3;
        var expNum = new Expr.Exponent(VALUE, DEGREE);

        final int EXPECTED_COUNT = 8;

        assertEquals(EXPECTED_COUNT, expNum.evaluate());
    }

    @Test
    @DisplayName("Тест сложения")
    void additionTest() {
        final int FIRST_VALUE = 991;
        final int SECOND_VALUE = 9;
        var sum = new Expr.Addition(FIRST_VALUE, SECOND_VALUE);

        final int EXPECTED_VALUE = 1000;

        assertEquals(EXPECTED_VALUE, sum.evaluate());
    }

    @Test
    @DisplayName("Тест умножения")
    void multiplicationTest() {
        final int FIRST_VALUE = 15;
        final int SECOND_VALUE = 10;
        var multiplication = new Expr.Multiplication(FIRST_VALUE, SECOND_VALUE);

        final int EXPECTED_VALUE = 150;

        assertEquals(EXPECTED_VALUE, multiplication.evaluate());
    }
}
