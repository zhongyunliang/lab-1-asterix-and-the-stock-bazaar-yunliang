package part1;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.*;

public class StockServer {
    private static final int PORT = 8888;
    private static final int MAX_THREADS = 10;
    private static InetAddress IP_ADDRESS;
   
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the number of the thread" + "\n");
        int threadsNum = scanner.nextInt();
        //create a static number (80) of threads and wait for requests
        ThreadPool threadPool = new ThreadPool(threadsNum);
        //get the ip address of the server
        try {
            IP_ADDRESS = InetAddress.getLocalHost();
            System.out.println("Local IP address: " + IP_ADDRESS);
        } catch (UnknownHostException ex) {
            System.err.println("Cloud not determine local IP address.");
        }
        //create a server with port 8888 and ip address
        ServerSocket serverSocket = new ServerSocket(PORT, 0, IP_ADDRESS);
        System.out.println("Stock server started on port " + PORT);

        while (true) {
            //listen for a connection, block until a connection is made
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
