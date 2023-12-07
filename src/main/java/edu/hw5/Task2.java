package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private Task2() {
    }

    private final static int MONTH = 1;
    private final static int THIRTEENTH_DAY_AT_MONTH = 13;

    public static List<LocalDate> findFridays13InTheYear(int year) {
        List<LocalDate> fridays = new ArrayList<>();
        LocalDate thirteenthInTheYear = LocalDate.of(year, MONTH, THIRTEENTH_DAY_AT_MONTH);
        while (thirteenthInTheYear.getYear() == year) {
            if (thirteenthInTheYear.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridays.add(thirteenthInTheYear);
            }
            thirteenthInTheYear = thirteenthInTheYear.plusMonths(MONTH);
        }
        return fridays;
    }

    public static LocalDate findNextFriday13th(LocalDate date) {
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        LocalDate currDate = date;
        while (currDate.getDayOfMonth() != THIRTEENTH_DAY_AT_MONTH) {
            currDate = currDate.with(temporalAdjuster);
        }
        return currDate;
    }
}
