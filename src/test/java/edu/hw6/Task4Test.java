package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    private final static Path PATH = Path.of("src/main/resources/text.txt");
    @Test
    @DisplayName("Проверка текста в файле")
    void testThatTextAtTheFileReturnedSucceed() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/text.txt"));
        writer.write("");
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/text.txt"));

        Task4.writeText(PATH);
        String str = reader.readLine();


        final String EXPECTED_TEXT = "Programming is learned by writing programs. ― Brian Kernighan";
        assertEquals(EXPECTED_TEXT, str);
    }
}
