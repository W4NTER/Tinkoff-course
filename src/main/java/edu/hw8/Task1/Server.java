package edu.hw8.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Server {
    private final static int PORT = 7778;
    private final static int MAX_CONNECTIONS = 5;
    private final static Logger LOGGER = LogManager.getLogger();


    private Server() {}

    public static void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS);
            //лочиться если превышено максимальное количество соединений
            while (true) {
                LOGGER.info("Server started");
                Socket socket = serverSocket.accept();
                executorService.execute(new ClientHandler(socket));
            }
        } finally {
            serverSocket.close();
        }
    }
}
