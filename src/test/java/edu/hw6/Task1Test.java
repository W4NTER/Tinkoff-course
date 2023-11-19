package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    private final DiskMap DISK_MAP =
        new DiskMap("test.txt");
    private final File FILE =
        new File("test.txt");
    //Изначально в файле вот такие данные:
    //Str:Str
    //name:surname
    //key:value

    @Test
    @DisplayName("Проверка записывания с файла в map")
    void testThatReadAndCrateLinesToMapReturnedSucceed() {
        final String EXPECTED_KEY1 = "Str";
        final String EXPECTED_KEY2 = "name";
        final String EXPECTED_KEY3 = "key";


        final Map<String, String> result = DISK_MAP.readMap();

        final Map<String, String> EXPECTED_MAP =
            Map.of("Str", "Str", "name", "surname", "key", "value");
        assertEquals(EXPECTED_MAP.get(EXPECTED_KEY1), result.get(EXPECTED_KEY1));
        assertEquals(EXPECTED_MAP.get(EXPECTED_KEY2), result.get(EXPECTED_KEY2));
        assertEquals(EXPECTED_MAP.get(EXPECTED_KEY3), result.get(EXPECTED_KEY3));
    }
}
