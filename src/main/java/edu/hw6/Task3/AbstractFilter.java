package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter filter) throws IOException {
        return entry -> this.accept(entry) && filter.accept(entry);
    }
}
