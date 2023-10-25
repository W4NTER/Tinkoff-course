package edu.hw2.Task3;

import javax.naming.CommunicationException;

public interface ConnectionManager {
    Connection getConnection() throws CommunicationException;
}
