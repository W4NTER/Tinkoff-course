package edu.hw8.Task2;

import java.util.concurrent.CompletableFuture;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Fibonacci {
    private static final Logger LOGGER = LogManager.getLogger();
    private final static int START_FIB = 1;

    private Fibonacci() {
    }

    public static long calcFibonacci(long value) {
        if (value <= START_FIB) {
            return value;
        }

        long fibMinus1 = 1;
        long fibMinus2 = 0;
        long fib = 0;

        for (int i = 1; i < value; i++) {
            fib = fibMinus2 + fibMinus1;
            fibMinus2 = fibMinus1;
            fibMinus1 = fib;
        }
        return fib;
    }

    public static long getFibValue(int countThreads, long countValues) {
        long result = -1;
        try {
            FixedThreadPool threadPool = FixedThreadPool.create(countThreads);
            threadPool.start();

            result = CompletableFuture.supplyAsync(() -> calcFibonacci(countValues), threadPool).get();

            threadPool.close();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return result;
    }
}
