package io.grpc.stock;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class StockServer {

    private Server server;

    private void start() throws IOException {
        int port = 8888;
        server = ServerBuilder.forPort(port)
                .addService(new ServiceImpl())
                .executor(Executors.newFixedThreadPool(5))
                .build()
                .start();
        //LogUtil.logger.info("Server started, listening on" + port);
        System.out.println("Server started, listening on" + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    StockServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final StockServer server = new StockServer();
        server.start();
        server.blockUntilShutdown();
    }
}
