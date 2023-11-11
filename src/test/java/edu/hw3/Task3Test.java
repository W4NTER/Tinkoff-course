package edu.hw3;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    @DisplayName("Проверка словаря - счетчика")
    void frequencyDictTest() {
        final List<String> inpStrings = List.of("this", "and", "that", "and");
        final List<Integer> inpIntegers = List.of(1, 1, 2, 2);
        final List<Character> inpChars = List.of('a', 'a', '/', '/', 's');

        final Map<String, Integer> resStrings = Map.of("this", 1, "and", 2, "that", 1);
        final Map<Integer, Integer> resIntegers = Map.of(1, 2, 2, 2);
        final Map<Character, Integer> resChars = Map.of('a', 2, '/', 2, 's', 1);

        assertEquals(resStrings, Task3.freqDict(inpStrings));
        assertEquals(resIntegers, Task3.freqDict(inpIntegers));
        assertEquals(resChars, Task3.freqDict(inpChars));
    }
}
