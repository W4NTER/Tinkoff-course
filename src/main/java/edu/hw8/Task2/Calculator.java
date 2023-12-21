package edu.hw8.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static edu.hw8.Task2.Fibonacci.calcFibonacci;


public class Calculator {
    private static final Logger LOGGER = LogManager.getLogger();
//    public static long getFibValue(int countThreads, long countValues) {
//        Fibonacci fibonacci = new Fibonacci();
//        try {
//            ThreadPool threadPool = FixedThreadPool.create(countThreads);
//            threadPool.start();
//            threadPool.execute(() -> {
//                fibonacci.setRES(calcFibonacci(countValues));
//            });
//            threadPool.close();
//        } catch (Exception e) {
//            LOGGER.info(e.getMessage());
//        }
//        return fibonacci.getRES();
//    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(10);
//        Fibonacci.getFibValue(4, 10);

        System.out.println(fibonacci.getRES());
    }
}
