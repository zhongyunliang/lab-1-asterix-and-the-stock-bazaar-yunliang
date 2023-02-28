package io.grpc.stock;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StockClient {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws Exception {
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        // 创建多个客户端线程并运行
        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(new ClientThread());
        }
        // 等待所有线程运行结束
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
