package edu.hw3;

public final class Task4 {
    private final static int[] ARABIC_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] ROMAN_SYMBOLS = {"M", "CM", "D", "CD", "C",
        "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private Task4() {
    }

    public static String convertToRoman(int arabicValue) {
        StringBuilder result = new StringBuilder();
        int value = arabicValue;

        for (int i = 0; i < ARABIC_VALUES.length; i++) {
            while (value >= ARABIC_VALUES[i]) {
                result.append(ROMAN_SYMBOLS[i]);
                value -= ARABIC_VALUES[i];
            }
        }
        return result.toString();
    }
}
