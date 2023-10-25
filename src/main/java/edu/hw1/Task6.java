package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private Task6() {
    }

    private static final int FINAL_VALUE = 6174;

    public static int countKRecursion(int num, int counter) {
        int numerator = counter;
        int number = num;
        StringBuilder value =  new StringBuilder(String.valueOf(num));
        int[] arrayNums = new int[] {0, 0, 0, 0};

        for (int i = 0; i < value.length(); i++) {
             arrayNums[i] = Integer.parseInt(value.substring(i, i + 1));
        }
        Arrays.sort(arrayNums);
        StringBuilder strValue = new StringBuilder();

        for (int arrayNum : arrayNums) {
            strValue.append(arrayNum);
        }

        int number1 = Integer.parseInt(strValue.toString());

        strValue.reverse();

        int number2 = Integer.parseInt(strValue.toString());

        if (num == FINAL_VALUE) {
            return counter;
        } else {
            number = Math.max(number1, number2) - Math.min(number1, number2);
            numerator++;
            return countKRecursion(number, numerator);
        }
    }

    public static int countK(int number) {
        int counter = 0;
        counter = countKRecursion(number, counter);
        return counter;
    }
}
