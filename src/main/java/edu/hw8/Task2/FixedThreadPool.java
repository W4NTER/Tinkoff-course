package edu.hw8.Task2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public final class FixedThreadPool implements Executor, ThreadPool {
    static volatile Boolean isRunning = true;
    private final Queue<Runnable> queue = new ConcurrentLinkedQueue<>();
    private final Thread[] threads;
    private final int nThreads;

    private FixedThreadPool(int nThreads) {
        this.nThreads = nThreads;
        this.threads = new Thread[nThreads];
    }

    @Override
    public void start() {
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new Thread(new Task());
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
    public void close() {
        isRunning = false;
    }

    private final class Task implements Runnable {
        @Override
        public void run() {
            while (isRunning) {
                var task = queue.poll();
                if (task != null) {
                    task.run();
                }
            }
        }
    }
}
