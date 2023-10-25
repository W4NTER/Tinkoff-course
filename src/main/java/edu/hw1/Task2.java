package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    private static final int DEGREE = 10;

    public static int countDigits(int value) {
        int degree = DEGREE;
        int digit = 0;
        int divisionResult = 1;
        while (divisionResult > 0) {
            divisionResult = value / degree;
            digit++;
            degree *= DEGREE;
        }
        return digit;
    }
}
