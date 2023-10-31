package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private Task6() {
    }

    private static final int FINAL_VALUE = 6174;
    private static final int DELIMITER = 10;
    private static final int ARRAY_LENGTH = 4;

    public static int countKRecursion(int num, int counter) {
        int numerator = counter;
        int[] arrayNums = new int[ARRAY_LENGTH];
        StringBuilder strValue = new StringBuilder();

        numToArr(num, arrayNums);
        Arrays.sort(arrayNums);

        for (int arrayNum : arrayNums) {
            strValue.append(arrayNum);
        }

        int number1 = Integer.parseInt(strValue.toString());

        strValue.reverse();

        int number2 = Integer.parseInt(strValue.toString());

        if (num == FINAL_VALUE) {
            return counter;
        } else {
            int number = Math.max(number1, number2) - Math.min(number1, number2);
            numerator++;
            return countKRecursion(number, numerator);
        }
    }

    public static int countK(int number) {
        int counter = 0;
        counter = countKRecursion(number, counter);
        return counter;
    }

    public static void numToArr(int num, int[] arr) {
        int number = num;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = number % DELIMITER;
            number /= DELIMITER;
        }
    }
}
