package edu.hw7.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MonteCarloMultiThreads {
    private MonteCarloMultiThreads() {
    }

    private final static int THREAD_COUNT = 4;
    private final static int POINTS_PER_THREAD = 25_000;
    private final static double VAL = 4;
    private final static int THREADS = 4;
    private final static Logger LOGGER = LogManager.getLogger();

    public static double findPi(int radius) {
        int circleCount = 0;
        double countPoints = THREAD_COUNT * POINTS_PER_THREAD;
        try (ExecutorService executor = Executors.newFixedThreadPool(THREADS)) {
            List<Future<Integer>> circleCounts = new ArrayList<>();

            for (int i = 0; i < THREAD_COUNT; i++) {
                Future<Integer> thread = executor.submit(() -> circleCount(radius));
                circleCounts.add(thread);
            }

            executor.shutdown();

            try {
                for (Future<Integer> future : circleCounts) {
                    circleCount += future.get();
                }
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
            }
            return VAL * (circleCount / countPoints);
        }
    }

    private static int circleCount(int radius) {
        int count = 0;
        for (int j = 0; j < POINTS_PER_THREAD; j++) {
            count = counter(radius, count);
        }
        return count;
    }

    private static int counter(int radius, int count) {
        int circleCount = count;
        double x = coordinate(radius);
        double y = coordinate(radius);
        if (StrictMath.pow(x, 2) + StrictMath.pow(y, 2) <= StrictMath.pow(radius, 2)) {
            circleCount++;
        }
        return circleCount;
    }

    private static double coordinate(int radius) {
        return ThreadLocalRandom.current().nextDouble(-radius, radius);
    }
}
