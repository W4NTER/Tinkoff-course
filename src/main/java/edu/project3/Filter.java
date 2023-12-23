package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Filter {
    private Filter() {
    }

    private final static Logger LOGGER = LogManager.getLogger();
    private static double averageWeight;
    private static int resource1 = 0;
    private static int resource2 = 0;
    private static int resource3 = 0;
    private final static String PRODUCT_1 = "product_1";
    private final static String PRODUCT_2 = "product_2";
    private final static String PRODUCT_3 = "product_3";
    private static OffsetDateTime startDate = OffsetDateTime.MAX;
    private static OffsetDateTime endDate = OffsetDateTime.MIN;
    private final static String OK_STATUS = "200";
    private final static String NF_STATUS = "404";
    private final static String NM_STATUS = "304";
    private final static String PC_STATUS = "206";
    private static int countOK = 0;
    private static int countNF = 0;
    private static int countNM = 0;
    private static int countPC = 0;
    private static int counter = 0;



    public static void requests(String[] input) {
        int numberOfGroup = 1;
        for (int i = 0; i < input.length; i++) {
            Pattern pattern = Pattern.compile("^.*\\[(.*)\\]\\s\\\".*/(.*)\\s.*\\\".*(\\d{3})\\s(\\d+)\\s\\\".*\\\"$");
            Matcher matcher = pattern.matcher(input[i]);
            if (matcher.find()) {
                dates(matcher.group(numberOfGroup));
                resources(matcher.group(++numberOfGroup));
                counterStatus(matcher.group(++numberOfGroup));
                refactorAnswerWeight(matcher.group(++numberOfGroup), input.length);
                numberOfGroup = 1;
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
            case PC_STATUS -> countPC++;
            default -> LOGGER.info("Необработанный статус: " + s);
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

    public static void resources(String resource) {
        switch (resource) {
            case PRODUCT_1 -> resource1++;
            case PRODUCT_2 -> resource2++;
            case PRODUCT_3 -> resource3++;
            default -> LOGGER.info("Нобработанный ресурс: " + resource);
        }
    }

    public static int getResource3() {
        return resource3;
    }

    public static int getCountPC() {
        return countPC;
    }

    public static double getAverageWeight() {
        return averageWeight;
    }

    public static int getResource1() {
        return resource1;
    }

    public static int getResource2() {
        return resource2;
    }

    public static OffsetDateTime getStartDate() {
        return startDate;
    }

    public static OffsetDateTime getEndDate() {
        return endDate;
    }

    public static int getCountOK() {
        return countOK;
    }

    public static int getCountNF() {
        return countNF;
    }

    public static int getCountNM() {
        return countNM;
    }

    public static int getCounter() {
        return counter;
    }
}
