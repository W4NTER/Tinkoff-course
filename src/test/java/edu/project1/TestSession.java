package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.SplittableRandom;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSession {
    private final static String ANSWER = "add";
    private final static char[] USER_ANSWER = {'a', '*', '*'};
    private final static int MAX_ATTEMPTS = 4;

    @Test
    @DisplayName("Проверка метода guess в ситуации Defeat")
    void defeatTest() {
        final int ATTEMPTS = 4;

        final char ANY_GUESS_TO_TEST = 'q';
        Session session = new Session(ANSWER, USER_ANSWER, MAX_ATTEMPTS, ATTEMPTS);
        GuessResult guessResult = new GuessResult.Defeat(USER_ANSWER);

        assertEquals(guessResult, session.guess(ANY_GUESS_TO_TEST));
    }

    @Test
    @DisplayName("Проверка метода guess в ситуации Win")
    void winTest() {
        final int ATTEMPTS = 0;

        final char ANY_GUESS_TO_TEST = 'd';
        Session session = new Session(ANSWER, USER_ANSWER, MAX_ATTEMPTS, ATTEMPTS);
        GuessResult guessResult = new GuessResult.Win(USER_ANSWER);

        assertEquals(guessResult, session.guess(ANY_GUESS_TO_TEST));
    }

    @Test
    @DisplayName("Проверка метода guess в ситуации FailedGuess")
    void failedGuessTest() {
        final int ATTEMPTS = 2;

        final char ANY_GUESS_TO_TEST = 'q';
        Session session = new Session(ANSWER, USER_ANSWER, MAX_ATTEMPTS, ATTEMPTS);
        GuessResult guessResult = new GuessResult.FailedGuess(ATTEMPTS, MAX_ATTEMPTS, USER_ANSWER);

        assertEquals(guessResult, session.guess(ANY_GUESS_TO_TEST));
    }

    @Test
    @DisplayName("Проверка метода guess в ситуации SuccessfulGuess")
    void successfulGuessTest() {
        final String ANSWER = "ada";
        final int ATTEMPTS = 2;

        final char ANY_GUESS_TO_TEST = 'd';
        Session session = new Session(ANSWER, USER_ANSWER, MAX_ATTEMPTS, ATTEMPTS);
        GuessResult guessResult = new GuessResult.SuccessfulGuess(ATTEMPTS, MAX_ATTEMPTS,USER_ANSWER);

        assertEquals(guessResult, session.guess(ANY_GUESS_TO_TEST));
    }

    @Test
    @DisplayName("Проверка метода giveUp")
    void giveUpTest() {
        final int ATTEMPTS = 1;
        final String GIVE_UP = "giveUp";
        Session session = new Session(ANSWER, USER_ANSWER, MAX_ATTEMPTS, ATTEMPTS);
        GuessResult guessResult = new GuessResult.Defeat(USER_ANSWER);

        assertEquals(guessResult, session.giveUp(GIVE_UP));
    }


}
