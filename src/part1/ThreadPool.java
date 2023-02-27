package part1;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
    private final int nThreads;
    private final PoolWorker[] threads;
    private final Queue<Runnable> queue;

    public ThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedList<>();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker(queue);
            threads[i].start();
        }
    }
    public void execute(Runnable task) {
        synchronized(queue) {
            queue.add(task);
            queue.notify();
        }
    }
}

