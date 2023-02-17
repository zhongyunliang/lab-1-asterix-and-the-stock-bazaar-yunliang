package part1;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class StockServer {
    private static final int PORT = 8888;
    private static final int MAX_THREADS = 10;
   
    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Stock server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getInetAddress().getHostAddress());

            try {
                threadPool.execute(new ClientHandler(clientSocket));
            } catch (RejectedExecutionException e) {
                System.err.println("Request rejected: " + e);
                clientSocket.close();
            }
        }
    }
}
