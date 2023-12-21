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
        System.out.println("a");
        return fib;
    }

    public static long getFibValue(int countThreads, long countValues) {
        try {
            ThreadPool threadPool = FixedThreadPool.create(countThreads);
            threadPool.start();
            threadPool.execute(() -> {
                RES = calcFibonacci(countValues);
                System.out.println(RES);
            });
            threadPool.close();
//            Thread.sleep(100);

        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return RES;
    }

//    public static int test(int countThreads) {
//        if (countThreads > 0) {
//            return 0;
//        }
//
//    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(10);
        System.out.println(fibonacci.RES);
    }
}
