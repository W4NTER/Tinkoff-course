package edu.hw1;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        return getMin(arr1) > getMin(arr2) && getMax(arr1) < getMax(arr2);
    }

    public static int getMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }
}
