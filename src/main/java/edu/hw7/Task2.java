package edu.hw7;

import java.util.stream.LongStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
}
