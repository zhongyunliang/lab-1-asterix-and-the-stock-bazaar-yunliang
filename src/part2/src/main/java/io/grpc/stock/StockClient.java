package io.grpc.stock;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StockClient {
    private static final int NUM_THREADS = 5;
    private static String IP_ADDRESS;
    private static int PORT;

    public static void main(String[] args) throws Exception {
        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Scanner scanner = new Scanner(System.in);
        //enter the ip address of the server
        System.out.println("Please enter the ip address you want to connect: ");
        IP_ADDRESS = scanner.nextLine();
        //enter the port of the server
        System.out.println("Please enter the port you want to connect: ");
        PORT = scanner.nextInt();


        // Create multiple client threads and run them
        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(new ClientThread(IP_ADDRESS, PORT));
        }
        // Wait for all threads to finish running
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
