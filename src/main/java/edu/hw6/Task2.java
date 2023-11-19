package edu.hw6;

import java.awt.SystemTray;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {

    public static void clone(Path path) throws IOException {
        if (Files.exists(path)) {
            String name = path.getFileName().toString();
            String directory = path.getParent().toString();
            String extension = "";

            int dotIndex = name.lastIndexOf(".");
            if (dotIndex != -1) {
                extension = name.substring(dotIndex);
                name = name.substring(0, dotIndex);
            }

            copyFile(name, directory, extension, path);
        }
    }

    public static void copyFile(String name, String directory, String extension, Path path) throws IOException {
        String copyName = name;
        int copyNumber = 0;
        while (Files.exists(Paths.get(directory, copyName + extension))) {
            copyNumber++;
            copyName = name + " — копия" + (copyNumber > 1 ? " (" + copyNumber + ")" : "");
        }

        Path copyPath = Paths.get(directory, copyName + extension);
        Files.copy(path, copyPath);
    }

    public static void main(String[] args) throws IOException {
        clone(Paths.get("C:\\Users\\snego\\OneDrive\\Рабочий стол\\Учеба\\Tinkoff_java\\test.txt"));
    }
}
