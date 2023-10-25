package edu.hw1;

public final class Task7 {
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        int length = Integer.toBinaryString(n).length();
        int shiftRes = shift % length;
        String rotateResult = Integer.toBinaryString(n >> shiftRes | n << (length - shiftRes));
        int resultLength = rotateResult.length();
        return Integer.parseInt(rotateResult.substring(resultLength - length, resultLength), 2);
    }

    public static int rotateLeft(int n, int shift) {
        int length = Integer.toBinaryString(n).length();
        int shiftRes = shift % length;
        String rotateResult = Integer.toBinaryString(n << shiftRes | n >> (length - shiftRes));
        int resultLength = rotateResult.length();
        return Integer.parseInt(rotateResult.substring(resultLength - length, resultLength), 2);
    }
}
