package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Filters {

    private Filters() {}

    public static AbstractFilter readable = new AbstractFilter() {
        @Override
        public boolean accept(Path entry) throws IOException {
            return Files.isReadable(entry);
        }
    };

    public static AbstractFilter writable = new AbstractFilter() {
        @Override
        public boolean accept(Path entry) throws IOException {
            return Files.isWritable(entry);
        }
    };

    public static AbstractFilter largerThan(long size) {
        return new AbstractFilter() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.size(entry) > size;
            }
        };
    }

    public static AbstractFilter lessThan(long size) {
        return new AbstractFilter() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.size(entry) < size;
            }
        };
    }

    public static AbstractFilter globMatches(String extension) {
        return new AbstractFilter() {
            @Override
            public boolean accept(Path entry) throws IOException {
                String path = entry.toString();
                path = path.substring(path.lastIndexOf(".") + 1);
                return path.equalsIgnoreCase(extension.substring(2));
            }
        };
    }

    public static AbstractFilter regexMatches(String regex) {
        return new AbstractFilter() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return entry.getFileName().toString().matches(regex);
            }
        };
    }
}

