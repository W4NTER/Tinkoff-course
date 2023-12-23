package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindDir extends RecursiveTask<List<Path>> {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int COUNT_FILES = 1000;
    private final Path directory;

    FindDir(Path directory) {
        this.directory = directory;
    }

    @Override
    protected List<Path> compute() {
        List<FindDir> subTasks = new ArrayList<>();
        List<Path> directories = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                if (Files.isDirectory(file)) {
                    FindDir subTask = new FindDir(file);
                    subTasks.add(subTask);
                    subTask.fork();
                }
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }

        for (FindDir subTask : subTasks) {
            directories.addAll(subTask.join());
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            int fileCount = 0;
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    fileCount++;
                }
            }
            if (fileCount > COUNT_FILES) {
                directories.add(directory);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return directories;
    }

    public static List<Path> run(String string) {
        Path path = Path.of(string);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<Path> findDir = forkJoinPool.invoke(new FindDir(path));
        forkJoinPool.close();
        return findDir;
    }
}
