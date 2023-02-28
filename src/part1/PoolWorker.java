package part1;

import java.util.Queue;

public class PoolWorker extends Thread {
    private final Queue<Runnable> queue;

    public PoolWorker(Queue<Runnable> queue){
        this.queue = queue;
    }
    public void run() {
        Runnable task;

        while (true) {
            synchronized(queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        System.out.println("An error occurred while waiting for a task: " + e.getMessage());
                    }
                }
                task = queue.poll();
            }

            try {
                task.run();
            } catch (RuntimeException e) {
                System.out.println("An error occurred while executing a task: " + e.getMessage());
            }
        }
    }
}