package edu.hw7;

import edu.hw7.Task4.MonteCarloMultiThreads;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Проверка правильности значений")
    void testThatNormalValuesCheckReturnedSucceed() {
        double res = MonteCarloMultiThreads.findPi(10);
        int result = (int) StrictMath.floor(res);

        final int EXPECTED_VALUE = 3;
        assertEquals(EXPECTED_VALUE, result);
        //Взял максимально грубо, но если количество точек больше миллиона - точность до сотых
        //Также провел замеры, на миллионе точек - выигрышь в производительности - около 2р,
        // хотел потестить на 100млн, но ноут крехтел пару минут и я не выдержал, сбросил.
        // Что было бы на последовательном варианте - боюсь предположить
    }
}
