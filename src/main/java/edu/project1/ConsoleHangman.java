package edu.project1;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int MAX_ATTEMPTS = 5;
    private final static int START_ATTEMPTS = 0;
    private final static String ANSWER = new ChooseWord().randomWord();
    private final static char[] START_USER_ANSWER = new char[ANSWER.length()];
    private final static int INDEX_OF_INPUT = 0;

    public void run() throws IllegalArgumentException {
        Scanner command = new Scanner(System.in);
        Arrays.fill(START_USER_ANSWER, '*');
        Session session = new Session(ANSWER, START_USER_ANSWER, MAX_ATTEMPTS, START_ATTEMPTS);
        GuessResult guessResult;
        while (session.getAttempts() != -1) {
            try {
                LOGGER.info("Guess a letter:");
                String guess = readLine(command);
                guessResult = tryGuess(session, guess);
                session.setAttempts(guessResult.attempt());

                printState(guessResult);
                LOGGER.info("The word: " + String.valueOf(guessResult.state()));
            } catch (StringIndexOutOfBoundsException e) {
                LOGGER.info("You entered an empty line");
            }
        }
        command.close();
    }

    private GuessResult tryGuess(Session session, String input) {
        if (input.length() > 1) {
            return session.giveUp(input);
        } else {
            return session.guess(input.charAt(INDEX_OF_INPUT));
        }
    }

    private void printState(GuessResult guess) {
        LOGGER.info(guess.message());
    }

    private String readLine(Scanner command) {
        return command.nextLine();
    }

}
