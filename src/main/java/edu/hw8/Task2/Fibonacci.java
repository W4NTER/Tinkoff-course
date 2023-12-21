package edu.hw8.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Fibonacci {
    private static final Logger LOGGER = LogManager.getLogger();
    private volatile static long RES;

    public Fibonacci(long value) {
        RES = getFibValue(4, value);
    }

    public static long getRES() {
        return RES;
    }

    public static long calcFibonacci(long value) {
        if (value <= 1) {
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
        try {
            ThreadPool threadPool = FixedThreadPool.create(countThreads);
            threadPool.start();
            threadPool.execute(() -> {
                RES = calcFibonacci(countValues);
            });
            threadPool.close();
            Thread.sleep(100);

        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return RES;
    }

}
