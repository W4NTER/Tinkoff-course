package edu.hw1;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String input) {
        StringBuilder fixedString = new StringBuilder();
        for (int i = 1; i < input.length(); i += 2) {
            fixedString.append(input.charAt(i));
            fixedString.append(input.charAt(i - 1));
        }
        if (input.length() % 2 == 1) {
            fixedString.append(input.charAt(input.length() -  1));
        }
        return new String(fixedString);
    }
}
