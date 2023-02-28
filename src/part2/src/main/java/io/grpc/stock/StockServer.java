package io.grpc.stock;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import io.grpc.Server;
import io.grpc.ServerBuilder;


public class StockServer {
    private static final int PORT = 9999;
    private static InetAddress IP_ADDRESS;

    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new ServiceImpl())
                .executor(Executors.newFixedThreadPool(5))
                .build()
                .start();
        IP_ADDRESS = InetAddress.getLocalHost();
        System.out.println("Local IP address: " + IP_ADDRESS + "\n" + "Server started, listening on" + PORT);
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
