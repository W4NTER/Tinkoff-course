package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        StringBuilder variableNumber = new StringBuilder(String.valueOf(number));
        if (variableNumber.toString().contentEquals(variableNumber.reverse()) && variableNumber.length() > 1) {
            return true;
        } else if (variableNumber.length() > 1) {
            variableNumber.reverse();
            StringBuilder createdNumber = createNewNumber(variableNumber);
          return isPalindromeDescendant(Integer.parseInt(createdNumber.toString()));
        } else {
            return false;
        }
    }

    public static StringBuilder createNewNumber(StringBuilder number) {
        StringBuilder createdNumber = new StringBuilder();
        for (int i = 0; i < number.length() - 1; i += 2) {
            createdNumber.append(Integer.parseInt(number.substring(i, i + 1))
                + Integer.parseInt(number.substring(i + 1, i + 2)));
        }
        return createdNumber;
    }
}
