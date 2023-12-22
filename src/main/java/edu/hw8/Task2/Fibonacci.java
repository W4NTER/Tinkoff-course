package edu.hw8.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Fibonacci {
    private static final Logger LOGGER = LogManager.getLogger();
    private static long result;
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

    public static long calc(long n) {
        if (n <= 1) {
            return n;
        }
        return calc(n - 1) + calc(n - 2);
    }

    public static long getFibValue(int countThreads, long countValues) {
        long time = System.currentTimeMillis();
        long r = -1;
        try {
            FixedThreadPool threadPool = FixedThreadPool.create(countThreads);
            threadPool.start();
            threadPool.execute(() -> {
                result = calc(countValues);
            });
            threadPool.close();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return result;
    }

//    public static long getVal(int countThreads, long countValues) throws ExecutionException, InterruptedException {
//        long time = System.currentTimeMillis();
//        ExecutorService service = Executors.newFixedThreadPool(countThreads);
////        Future<Long> res = service.submit(() -> calc(countValues));
//
//        var a = CompletableFuture.supplyAsync(() -> calc(countValues), service);
//
//        System.out.println(System.currentTimeMillis() - time);
//        return a.get();
//    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        long time = System.currentTimeMillis();
//        System.out.println("single " + calc(30));
//        System.out.println("single " + (System.currentTimeMillis() - time));
//
//        System.out.println("multi " + getFibValue(10, 30));
//        System.out.println();
//        System.out.println(getVal(4, 30));
//    }
}
