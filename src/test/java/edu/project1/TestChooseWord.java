package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestChooseWord {
    @Test
    void testChooseWord() {
        final String[] ARRAY_ANSWERS = {"hello", "say", "something"};

        String word = new ChooseWord().randomWord();

        assertTrue(Arrays.toString(ARRAY_ANSWERS).contains(word));
    }
}
