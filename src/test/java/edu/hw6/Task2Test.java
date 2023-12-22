package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    private final static Path PATH = Path.of("src/main/resources/test1.txt");
    @Test
    @DisplayName("Проверка создания копий файла")
    void testThatCopyFilesCheckReturnedSucceed() throws IOException {
        Path copy1 = Path.of("src/main/resources/test1 — копия.txt");
        Path copy2 = Path.of("src/main/resources/test1 — копия (2).txt");

        Task2.clone(PATH);
        Task2.clone(PATH);

        assertTrue(Files.exists(copy1));
        assertTrue(Files.exists(copy2));

        Files.delete(copy1);
        Files.delete(copy2);
    }
}
