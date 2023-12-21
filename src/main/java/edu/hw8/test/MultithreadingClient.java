package edu.hw8.test;


import edu.hw8.Task2.FixedThreadPool;
import edu.hw8.Task2.ThreadPool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static java.lang.String.format;

public class MultithreadingClient {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadPool1 threadPool = new ThreadPool1(8);
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        Counter counter = new Counter();

        long start = System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            final int j = i;
            futures.add(
                CompletableFuture.supplyAsync(
                    () -> counter.count(j),
                    threadPool
                ));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.println(format("Executed by %d s, value : %f",
            (System.nanoTime() - start) / (1000_000_000),
            value));

        threadPool.shutdown();
    }
}
