package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task3 {
    private final static int DEFAULT_VALUE = 1;

    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> input) {
        Map<T, Integer> result = new HashMap<>();
        for (T item : input) {
            result.put(item, result.getOrDefault(item, 0) + 1);
        }
        return result;
    }
}
