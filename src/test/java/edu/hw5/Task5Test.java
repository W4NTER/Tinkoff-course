package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Проверка правильности написания номерных автомобильных знаков РФ")
    void testThatPlateValidationOnEngAndRusTypingReturnedSucceed() {
        final String[] PLATES_FOT_TEST = {"А123ВЕ777", "О777ОО177", "123АВЕ777", "А123ВГ77", "А123ВЕ7777"};

        assertTrue(Task5.plateValidation(PLATES_FOT_TEST[0]));
        assertTrue(Task5.plateValidation(PLATES_FOT_TEST[1]));
        assertFalse(Task5.plateValidation(PLATES_FOT_TEST[2]));
        assertFalse(Task5.plateValidation(PLATES_FOT_TEST[3]));
    }
}
