package edu.hw2.Task3.exeption;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException() {
    }
}
