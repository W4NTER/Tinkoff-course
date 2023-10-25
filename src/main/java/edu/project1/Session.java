package edu.project1;

import edu.project1.GuessResult.Defeat;
import edu.project1.GuessResult.FailedGuess;
import edu.project1.GuessResult.SuccessfulGuess;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    @NotNull GuessResult guess(char guess) throws IllegalArgumentException {
        if (attempts == maxAttempts) {
            return new Defeat(userAnswer);
        } else if (answer.indexOf(guess) == -1) {
            return new FailedGuess(attempts, maxAttempts, userAnswer);
        } else if (!String.valueOf(userAnswer).contains("*")) {
            return new GuessResult.Win(userAnswer);
        } else {
            int position = answer.indexOf(guess);
            while (position != -1) {
                userAnswer[position] = guess;
                position = answer.indexOf(guess, position + 1);
            }
            return new SuccessfulGuess(attempts, maxAttempts, userAnswer);
        }
    }

    @NotNull GuessResult giveUp(String command) {
        if (command.equals("giveUp")) {
            return new Defeat(userAnswer);
        } else {
            return new FailedGuess(attempts, maxAttempts, userAnswer);
        }
    }

    public Session(String answer, char[] userAnswer, int maxAttempts, int attempts) {
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.maxAttempts = maxAttempts;
        this.attempts = attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }
}
