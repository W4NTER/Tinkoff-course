package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("ReturnCount")
public class ClientHandler extends Thread {
    private final Socket clientSocket;
    private BufferedWriter out;
    private BufferedReader in;
    private final static Logger LOGGER = LogManager.getLogger();

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String input;
            while (true) {
                input = in.readLine();
                String serverResponse = serverResponse(input);
                out.write(serverResponse + "\n");
                out.flush();
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static String serverResponse(String codeWord) {
        switch (codeWord) {
            case "личности" -> {
                return "Не переходи на личности там, где их нет";
            }
            case "оскорбления" -> {
                return "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами";
            }
            case "глупый" -> {
                return "А я тебе говорил, что ты глупый?"
                    + " Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.";
            }
            case "интеллект" -> {
                return "Чем ниже интеллект, тем громче оскорбления";
            }
            case "шакалы" -> {
                return "Если за спиной гавкают шакалы, значит ты впереди";
            }
            default -> {
                return "Нет шаблона";
            }
        }
    }
}
