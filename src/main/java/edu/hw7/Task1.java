package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task1 {
    private Task1() {}

    private final static Logger LOGGER = LogManager.getLogger();
    private static AtomicInteger counter = new AtomicInteger(0);

    public static AtomicInteger getCounter() {
        return counter;
    }

    public static void numerator(int countThreads, int num) {
        Thread[] treads = new Thread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            treads[i] = new Thread(() -> {
                for (int j = 0; j < num; j++) {
                    counter.getAndIncrement();
                }
            });
            treads[i].start();
        }

        for (int i = 0; i < countThreads; i++) {
            try {
                treads[i].join();
            } catch (InterruptedException e) {
                LOGGER.info("join failed");
            }
        }
    }
}
