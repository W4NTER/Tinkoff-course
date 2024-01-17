package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindFile extends RecursiveTask<List<Path>> {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Path directory;
    private final Predicate<Path> predicate;

    FindFile(Path directory, Predicate<Path> predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    protected List<Path> compute() {
        List<Path> res = new ArrayList<>();
        List<FindFile> subTasks = new ArrayList<>();

        try (var dirStream = Files.newDirectoryStream(directory)) {
            for (var path : dirStream) {
                if (Files.isDirectory(path)) {
                    FindFile subTask = new FindFile(path, predicate);
                    subTask.fork();
                    subTasks.add(subTask);
                } else {
                    if (predicate.test(path)) {
                        res.add(path);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        for (var subTask : subTasks) {
            res.addAll(subTask.join());
        }
        return res;
    }
}
