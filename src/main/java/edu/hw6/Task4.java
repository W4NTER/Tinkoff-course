package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task4 {
    private Task4() throws IOException {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void writeText(Path path) {
        try (OutputStream file = Files.newOutputStream(path);
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(file, new CRC32());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
            OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             PrintWriter out = new PrintWriter(outputStreamWriter, true)) {
            out.println("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
