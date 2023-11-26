package edu.hw7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.LongStream;

public final class Task2 {
    private Task2() {}

    private final static Logger LOGGER = LogManager.getLogger();

    public static long factorial(int num) {
        if (num < 0) {
            LOGGER.info("Число меньше нуля");
        }

        return LongStream
            .rangeClosed(1, num)
            .parallel()
            .reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        System.out.println(factorial(16));
    }
}
