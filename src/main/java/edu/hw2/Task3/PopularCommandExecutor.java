package edu.hw2.Task3;

import edu.hw2.Task3.exeption.ConnectionException;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int i = 0; i < maxAttempts - 1; i++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
            } catch (ConnectionException exception) {
                if (i == maxAttempts - 1) {
                    throw new ConnectionException("connection attempts limit exceeded");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
