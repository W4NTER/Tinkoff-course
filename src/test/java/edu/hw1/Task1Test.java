package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task1Test {
    @Test
    @DisplayName("Время видео в секундах")
    void videoLengthInSeconds() {
        final String VIDEO_LENGTH_TEST = "01:00";
        final int EXPECTED_VALUE = 60;
        //when
        int lengthInSeconds = Task1.minutesToSeconds(VIDEO_LENGTH_TEST);

        //then
        assertEquals(EXPECTED_VALUE, lengthInSeconds);
    }

    @Test
    @DisplayName("Тест на предел секунд")
    void videoLengthInSecondsWithFullSec() {
        final String VIDEO_LENGTH_FULL_SEC = "1:60";
        final int EXPECTED_VALUE = -1;

        int lengthInSeconds = Task1.minutesToSeconds(VIDEO_LENGTH_FULL_SEC);

        assertEquals(EXPECTED_VALUE, lengthInSeconds);
    }

    @Test
    @DisplayName("Проверка на большое количество минут")
    void videoLengthInSecondsWithALotMin() {
        final String VIDEO_LENGTH_A_LOT_OF_MIN = "11212:10";
        final int EXPECTED_VALUE = 672730;

        int lengthInSeconds = Task1.minutesToSeconds(VIDEO_LENGTH_A_LOT_OF_MIN);

        assertEquals(EXPECTED_VALUE, lengthInSeconds);
    }

    @Test
    @DisplayName("Неправильный ввод данных")
    void incorrectData() {
        final String VIDEO_LENGTH_INCORRECT = "abc:abc";
        final int EXPECTED_VALUE = -1;

        assertEquals(EXPECTED_VALUE, Task1.minutesToSeconds(VIDEO_LENGTH_INCORRECT));
    }
}
