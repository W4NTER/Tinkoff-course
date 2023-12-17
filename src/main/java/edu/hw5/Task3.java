package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task3 {
    private Task3() {}

    private static final DateTimeFormatter[] DATE_FORMATS = {
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("yyyy-M-d"),
        DateTimeFormatter.ofPattern("M/d/yyyy"),
        DateTimeFormatter.ofPattern("M/d/yy")
    };

    public static Optional<LocalDate> parseCustomFormats(String string) {
        Optional<LocalDate> customDate = Optional.empty();
        if (string.equals("tomorrow")) {
            customDate = Optional.of(LocalDate.now().plusDays(1));
        } else if (string.equals("today")) {
            customDate = Optional.of(LocalDate.now());
        } else if (string.equals("yesterday")) {
            customDate = Optional.of(LocalDate.now().minusDays(1));
        } else if (string.equals("1 day ago")) {
            customDate = Optional.of(LocalDate.now().minusDays(1));
        } else if (string.matches("([1-9]\\d*) days ago$")) {
           Pattern pattern = Pattern.compile("([1-9]\\d*)");
           Matcher m = pattern.matcher(string);
           m.find();
           customDate = Optional.of(LocalDate.now().minusDays(Integer.parseInt(m.group(1))));
        }
        return customDate;
    }

    public static Optional<LocalDate> parseDate(String string) {
        return parseWithFormats(string, 0);
    }

    private static Optional<LocalDate> parseWithFormats(String string, int index) {
        if (index >= DATE_FORMATS.length) {
            return parseCustomFormats(string);
        }

        try {
            LocalDate date = LocalDate.parse(string, DATE_FORMATS[index]);
            return Optional.of(date);
        } catch (Exception e) {
            return parseWithFormats(string, index + 1);
        }
    }
}
