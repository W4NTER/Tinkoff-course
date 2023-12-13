package edu.hw6;

import edu.hw6.Task1.DiskMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {

    private final DiskMap DISK_MAP =
        new DiskMap("src/main/resources/test1.txt");
    private final Map<String, String> BASE_STATE_OF_MAP = Map.of("Str", "Str", "name", "surname", "key", "value");
//    Изначально в файле вот такие данные:
//    Str:Str
//    name:surname
//    key:value

    @BeforeEach
    void clearFile() {
        DISK_MAP.clear();
    }

    @Test
    @DisplayName("Проверка записи с файла в map")
    void testThatWriteAndReadLinesToMapReturnedSucceed() {
        final String EXPECTED_KEY1 = "Str";
        final String EXPECTED_KEY2 = "name";
        final String EXPECTED_KEY3 = "key";
        final String EXPECTED_KEY4 = "KEY";

        DISK_MAP.putAll(BASE_STATE_OF_MAP);
        DISK_MAP.put("KEY", "VALUE");
        final Map<String, String> read = DISK_MAP.readMap();

        final Map<String, String> EXPECTED_MAP =
            Map.of("Str", "Str", "name", "surname", "key", "value", "KEY", "VALUE");
        assertEquals(EXPECTED_MAP.get(EXPECTED_KEY1), read.get(EXPECTED_KEY1));
        assertEquals(EXPECTED_MAP.get(EXPECTED_KEY2), read.get(EXPECTED_KEY2));
        assertEquals(EXPECTED_MAP.get(EXPECTED_KEY3), read.get(EXPECTED_KEY3));
        assertEquals(EXPECTED_MAP.get(EXPECTED_KEY4), read.get(EXPECTED_KEY4));
    }

    @Test
    @DisplayName("Проверка метода size()")
    void testThatSizeMethodCheckReturnedSucceed() {
        DISK_MAP.putAll(BASE_STATE_OF_MAP);
        final int res = DISK_MAP.size();

        final int EXPECTED_VALUE = 3;
        assertEquals(EXPECTED_VALUE, res);
    }

    @Test
    @DisplayName("Проверка удаления элементов словаря")
    void testThatRemovingObjFromMapReturnedSucceed() {
        DISK_MAP.putAll(BASE_STATE_OF_MAP);

        DISK_MAP.remove("Str");
        Map<String, String> res = DISK_MAP.readMap();

        Map<String, String> resMap =
            Map.of( "name", "surname", "key", "value");
        assertEquals(resMap, res);
    }

    @Test
    @DisplayName("Проверка полной очистки словаря")
    void testThatClearMapReturnedSucceed() {
        Map<String, String> clearMap = new HashMap<>();

        Map<String, String> res = DISK_MAP.readMap();

        assertEquals(clearMap, res);
    }

    @Test
    @DisplayName("Проверка метода isEmpty")
    void testThatCheckMethodIsEmptyReturnedSucceed() {
        assertTrue(DISK_MAP.isEmpty());
    }

    @Test
    @DisplayName("Проверка заполнения словаря методом putAll")
    void testThatPutAllToClearMapReturnedSucceed() {
        Map<String, String> originalMap =
            Map.of( "name", "surname", "key", "value", "KEY", "VALUE");

        DISK_MAP.putAll(originalMap);
        var res = DISK_MAP.readMap();

        assertEquals(originalMap, res);
    }

    @Test
    @DisplayName("Проверка метода keySet")
    void testThatKeySetCheckReturnedSucceed() {;
        DISK_MAP.putAll(BASE_STATE_OF_MAP);

        var keys = DISK_MAP.keySet();

        var originalKeys = BASE_STATE_OF_MAP.keySet();
        assertEquals(originalKeys, keys);
    }
 }
