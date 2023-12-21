package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
    private static double averageWeight;
    private String resource;
    private static OffsetDateTime startDate = OffsetDateTime.MAX;
    private static OffsetDateTime endDate = OffsetDateTime.MIN;
    private final static String OK_STATUS = "200";
    private final static String NF_STATUS = "404";
    private final static String NM_STATUS = "304";
    private static int countOK = 0;
    private static int countNF = 0;
    private static int countNM = 0;
    private static int counter = 0;



    public static void requests(String[] input) {
        for (int i = 0; i < input.length; i++) {
            Pattern pattern = Pattern.compile("^.*\\[(.*)\\].*(\\d{3})\\s(\\d+)\\s\".*\"$");
            Matcher matcher = pattern.matcher(input[i]);
            if (matcher.find()) {
                dates(matcher.group(1));
                counterStatus(matcher.group(2));
                refactorAnswerWeight(matcher.group(3), input.length);
            }
        }
        counter = input.length;
    }

    public static void refactorAnswerWeight(String weight, int countElements) {
        averageWeight += Integer.parseInt(weight) / (double) countElements;
    }

    public static void counterStatus(String s) {
        switch (s) {
            case OK_STATUS -> countOK++;
            case NF_STATUS -> countNF++;
            case NM_STATUS -> countNM++;
        }
    }

    public static void dates(String dateTime) {
        OffsetDateTime date = OffsetDateTime
            .parse(dateTime,
                DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH));
        if (startDate.isAfter(date)) {
            startDate = date;
        }

        if (endDate.isBefore(date)) {
            endDate = date;
        }
    }

    public static void main(String[] args) {
//        OpenFile openFile = new OpenFile();
//        String[] arr = openFile.readFile("src/main/resources/logs.txt");

        OpenLink openLink = new OpenLink();
        String[] arr = openLink.openLink("https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");

        requests(arr);
        System.out.println(countOK);
        System.out.println(countNF);
        System.out.println(countNM);
        System.out.println(counter);
        System.out.println("\n");
        System.out.println(startDate.toLocalDate());
        System.out.println(endDate.toLocalDate());
        System.out.println((long) averageWeight);

    }
}
