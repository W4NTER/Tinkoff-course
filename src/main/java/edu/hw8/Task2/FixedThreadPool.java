package edu.hw8.Task2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public final class FixedThreadPool implements ThreadPool, Executor {
    private volatile Boolean isRunning = true;
    private final Queue<Runnable> queue = new ConcurrentLinkedQueue<>();
    private final Thread[] threads;
    private final int nThreads;

    private FixedThreadPool(int nThreads) {
        this.nThreads = nThreads;
        this.threads = new Thread[nThreads];
        this.start();
    }

    @Override
    public void start() {
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new Thread(() -> {
                while (isRunning) {
                    var task = queue.poll();
                    if (task != null) {
                        task.run();
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (isRunning) {
            queue.offer(runnable);
        }

    }

    public static FixedThreadPool create(int nThreads) {
        return new FixedThreadPool(nThreads);
    }

    @Override
    public void close() throws Exception {
        isRunning = false;
    }
}
