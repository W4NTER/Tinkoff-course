package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task3.Filters.globMatches;
import static edu.hw6.Task3.Filters.largerThan;
import static edu.hw6.Task3.Filters.readable;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    private final static Path PATH = Path.of("src/main/resources");

    @Test
    @DisplayName("Проверка запроса всех записей в каталоге")
    void testThatNewDirectoryStreamWithNoParamReturnedSucceed() {
        List<String> files = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH)) {
            for (Path file : entries) {
                files.add(file.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final List<String> EXPECTED_FILES =
            List.of(
                "src\\main\\resources\\log4j2.xml",
                "src\\main\\resources\\test1.txt",
                "src\\main\\resources\\text.txt"
            );
        assertEquals(EXPECTED_FILES, files);
    }

    @Test
    @DisplayName("Проверка запроса записей с glob строкой (*.txt)")
    void testThatFindAllTextFilesReturnedSucceed() {
        List<String> files = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, "*.txt")) {
            for (Path file : entries) {
                files.add(file.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final List<String> EXPECTED_FILES =
            List.of(
                "src\\main\\resources\\test1.txt",
                "src\\main\\resources\\text.txt"
            );
        assertEquals(EXPECTED_FILES, files);
    }

    @Test
    @DisplayName("Проверка запроса записей с фильтрами")
    void testThatFindFilesByFiltersReturnedSucceed() {
        List<String> files = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(PATH, filter())) {
            for (Path file : entries) {
                files.add(file.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final List<String> EXPECTED_FILES =
            List.of(
                "src\\main\\resources\\log4j2.xml"
            );
        assertEquals(EXPECTED_FILES, files);
    }

    private DirectoryStream.Filter<Path> filter() throws IOException {
        edu.hw6.Task3.AbstractFilter regularFile = Files::isRegularFile;
        return regularFile
            .and(readable)
            .and(largerThan(4))
            .and(globMatches("*.xml"));
    }

}
