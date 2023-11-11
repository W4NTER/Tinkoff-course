package edu.hw3;

import java.util.ArrayList;

public final class Task2 {
    private final static char START_BRACKET = '(';
    private final static char END_BRACKET = ')';

    private Task2() {
    }

    public static String[] clusterize(String input) {
        StringBuilder elInList = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        int countBrackets = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == START_BRACKET) {
                elInList.append(START_BRACKET);
                countBrackets++;
            } else {
                elInList.append(END_BRACKET);
                countBrackets--;
            }
            if (countBrackets == 0) {
                result.add(String.valueOf(elInList));
                elInList.delete(0, i + 1);
            }
        }
        return result.toArray(new String[0]);
    }
}
