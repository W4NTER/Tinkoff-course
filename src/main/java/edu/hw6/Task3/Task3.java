package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Task3 {
    private Task3() {}

    public static AbstractFilter regularFile = Files::isRegularFile;
    public static AbstractFilter readable = Files::isReadable;

    public static DirectoryStream<Path> newDirectoryStream(Path dir) throws IOException {
        return Files.newDirectoryStream(dir);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir, String glob) throws IOException {
        return Files.newDirectoryStream(dir, "*" + glob);
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir,
        DirectoryStream.Filter<? super Path> filter) throws IOException {
        return Files.newDirectoryStream(dir, filter);
    }
}
