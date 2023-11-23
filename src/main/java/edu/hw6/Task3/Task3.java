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
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir);
        return directoryStream;
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir, String glob) throws IOException {
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, "*" + glob);
        return directoryStream;
    }

    public static DirectoryStream<Path> newDirectoryStream(Path dir,
        DirectoryStream.Filter<? super Path> filter) throws IOException {
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, filter);
        return directoryStream;
    }
}
