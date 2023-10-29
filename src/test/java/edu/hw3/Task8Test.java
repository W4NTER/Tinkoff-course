package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Проверка обратного порядка в итераторе")
    void backwardIteratorTest() {
        final List<Integer> INPUT = List.of(1, 2, 3);
        final String RESULT = "321";
        BackwardIterator<Integer> iterator = new BackwardIterator<>(INPUT);

        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }

        assertTrue(RESULT.contentEquals(String.valueOf(result)));

    }
}
