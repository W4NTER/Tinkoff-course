package edu.hw5;

public final class Task4 {
    private Task4() {
    }

    public static boolean regularExpressionForThePassword(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
