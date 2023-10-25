package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;




class Task1Test {

    @Test
    @DisplayName("Время видео в секундах")
    void videoLengthInSeconds() {
        //given
        String videoLength = "01:00";

        //when
        int lengthInSeconds = Task1.minutesToSeconds(videoLength);

        //then
        assertEquals(60, lengthInSeconds);

    }

    @Test
    @DisplayName("Тест2")
    void videoLengthInSeconds2() {

        String videoLength = "13:56";

        int lengthInSeconds = Task1.minutesToSeconds(videoLength);

        assertEquals(836, lengthInSeconds);
    }

    @Test
    @DisplayName("Тест3")
    void videoLengthInSecondsWithFullSec() {

        String videoLength = "1:60";

        int lengthInSeconds = Task1.minutesToSeconds(videoLength);

        assertEquals(-1, lengthInSeconds);
    }

    @Test
    @DisplayName("Тест4")
    void videoLengthInSecondsWithALotMin() {

        String videoLength = "11212:10";

        int lengthInSeconds = Task1.minutesToSeconds(videoLength);

        assertEquals(672730, lengthInSeconds);
    }

}
