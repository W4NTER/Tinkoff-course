package edu.hw7.Task4;

import java.security.SecureRandom;

public final class MonteCarlo {
    private MonteCarlo() {}

    private final static double COUNT_POINTS = 1_000_000;
    private final static double VAL = 4;

    public static double findPi(int radius) {
        int circleCount = 0;
        for (int i = 0; i < COUNT_POINTS; i++) {
            double x = coordinate(radius);
            double y = coordinate(radius);
            if (StrictMath.pow(x, 2) + StrictMath.pow(y, 2) <= StrictMath.pow(radius, 2)) {
                circleCount++;
            }
        }
        return VAL * (circleCount / COUNT_POINTS);
    }

    private static double coordinate(int radius) {
        SecureRandom random = new SecureRandom();
        return random.nextDouble(-radius, radius);
    }
}
