package edu.hw5;

public final class Task7 {
    private Task7() {}

    private final static int PAT1 = 1;
    private final static int PAT2 = 2;
    private final static int PAT3 = 3;

    public static boolean stringChecking(int pattern, String input) {
        switch (pattern) {
            case PAT1 -> {
                return input.matches("^[01]{2}0[01]*$");
            }
            case PAT2 -> {
                return input.matches("^([01])[01]*\\1$");
            }
            case PAT3 -> {
                return input.matches("^[01]?[01]?[01]$");
            }
            default -> {
                return false;
            }
        }
    }
}
