package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class ChooseWord implements Dictionary {
    private final static String[] ARRAY_ANSWERS = {"hello", "say", "something"};

    @Override
    public @NotNull String randomWord() {
        Random random = new Random();
        return ARRAY_ANSWERS[random.nextInt(0, ARRAY_ANSWERS.length)];
    }
}
