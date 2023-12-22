package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {
    private Task6() {
    }

    public static boolean substringByRegularExpression(String string, String substring) {
        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
