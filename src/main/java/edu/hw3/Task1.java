package edu.hw3;

public final class Task1 {
    private Task1() {
    }

    private final static int UPPER_CASE_A_IN_CHARS = 65;
    private final static int LOWER_CASE_A_IN_CHARS = 97;
    private final static int WORDS_IN_ALPHABET = 25;
    private final static int LAST_LETTER_IN_CHARS = 122;
    private final static int LAST_UPPER_CASE_LETTER = 90;

    public static String atbash(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch < UPPER_CASE_A_IN_CHARS || (ch > LAST_UPPER_CASE_LETTER && ch < LOWER_CASE_A_IN_CHARS) || ch > LAST_LETTER_IN_CHARS) {
                result.append(ch);
            } else {
                int offset = Character.isUpperCase(ch) ? UPPER_CASE_A_IN_CHARS : LOWER_CASE_A_IN_CHARS;
                char opposite = (char) ((WORDS_IN_ALPHABET - (ch - offset)) + offset);
                result.append(opposite);
            }
        }
        return result.toString();

    }
}
