package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public final class Task1 {
    private Task1() {
    }

    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
    private final static String TIME_SPLIT_HYPHEN = " - ";
    private final static int SECONDS_IN_HOUR = 3600;
    private final static int SECONDS_IN_MINUTE = 60;

    public static long timeInClub(String input) throws ParseException {
        String[] strStartEnd = input.split(TIME_SPLIT_HYPHEN);
        long time = computeTimeSpent(strStartEnd);
        return Duration.ofMillis(time).getSeconds();
    }

    public static long computeTimeSpent(String[] strStartEnd) throws ParseException {
        long timeStart = FORMAT.parse(strStartEnd[0]).getTime();
        long timeEnd = FORMAT.parse(strStartEnd[1]).getTime();
        return timeEnd - timeStart;
    }

    public static String averageTimeInTheClub(String[] input) throws ParseException {
        long fullTimeInClub = 0;
        for (String time : input) {
            fullTimeInClub += timeInClub(time);
        }
        long averageTimeInClub = fullTimeInClub / input.length;
        long hours = averageTimeInClub / SECONDS_IN_HOUR;
        long minutes = (averageTimeInClub % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        long seconds = ((averageTimeInClub % SECONDS_IN_HOUR) % SECONDS_IN_MINUTE) % SECONDS_IN_MINUTE;
        return String.format("%dч %dм %dс", hours, minutes, seconds);
    }
}
