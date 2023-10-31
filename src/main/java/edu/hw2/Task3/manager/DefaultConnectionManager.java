package edu.hw2.Task3.manager;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.connection.FaultyConnection;
import edu.hw2.Task3.connection.StableConnection;
import edu.hw2.Task3.exeption.ConnectionException;
import java.util.Random;

public final class DefaultConnectionManager implements ConnectionManager {
    private static final int LIMIT_TO_FAULTY = 6;
    private static final int LIMIT_TO_STABLE = 4;

    @Override
    public Connection getConnection() {
        return swapConnection();
    }

    private Connection swapConnection() throws ConnectionException {
        Random rand = new Random();

        if (rand.nextInt(1, LIMIT_TO_FAULTY) < LIMIT_TO_STABLE) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
