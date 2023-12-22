package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Client {
    private Client() {}

    private final static String SERVER_HOST = "localhost";
    private final static int PORT = 7778;
    private static final Logger LOGGER = LogManager.getLogger();

    public static void client() {
        try (
            Socket clientSocket = new Socket(SERVER_HOST, PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        ) {
            LOGGER.info("Введите фразу");

            String userInput = reader.readLine();

            while (userInput != null) {
                out.write(userInput + "\n");
                out.flush();

                String serverResponse = in.readLine();
                LOGGER.info(serverResponse);
                userInput = reader.readLine();
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

}
