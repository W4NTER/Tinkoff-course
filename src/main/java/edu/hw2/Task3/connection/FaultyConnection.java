package edu.hw2.Task3.connection;

import edu.hw2.Task3.Connection;
import edu.hw2.Task3.exeption.ConnectionException;
import java.util.Random;

public class FaultyConnection implements Connection {
    private final static double LIMIT = 0.6;

    @Override
    public void execute(String command) {
        Random rand = new Random();
        if (rand.nextInt() > LIMIT) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {
    }
}
