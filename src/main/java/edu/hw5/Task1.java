package edu.hw5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public final class Task1 {
    private Task1() {
    }

    public static long timeInClub(String input) throws ParseException {
        String[] strStartEnd = input.split(" - ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
        Long time = format.parse(strStartEnd[1]).getTime() - format.parse(strStartEnd[0]).getTime();
        Duration duration = Duration.ofMillis(time);
        return duration.getSeconds();
    }

    public static String averageTimeInTheClub(String[] input) throws ParseException { //обработать ошибку
        long fullTimeInClub = 0;
        for (String time : input) {
            fullTimeInClub += timeInClub(time);
        }
        long averageTimeInClub = fullTimeInClub / input.length; //Может получиться неровное число, переделать на даблы, сделать округление
        long hours = averageTimeInClub / 3600;
        long min = (averageTimeInClub % 3600) / 60 ;
        return String.format("%dч %dм",hours, min);
    }

    public static void main(String[] args) throws ParseException {
        String[] str = {"2022-04-01, 21:30 - 2022-04-02, 01:20", "2022-03-12, 20:20 - 2022-03-12, 23:50"};
        System.out.println((averageTimeInTheClub(str)));
    }
}
