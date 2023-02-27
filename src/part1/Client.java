package part1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private static final List<String> stockNames = new ArrayList<>();
    private static final int NUM_THREADS = 5;
    private static final List<String> delays = new ArrayList<>();
    private static String IP_ADDRESS;


    static {
        stockNames.add("GameStart");
        stockNames.add("FishCo");
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        //enter the ip address of the server
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ip address you want to connect: ");
        IP_ADDRESS = scanner.nextLine();
        //create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        //executor.submit(new ClientThread());
        for (int i = 0; i < 5; i++) {
            executor.submit(new ClientThread());
        }
        //waiting 2 mins for threads shutdown
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
        //show the delays of each client
        System.out.println(delays);
    }

    private static class ClientThread implements Runnable {

        private static final int PORT = 7777;
        private static final int NUMS_REQUEST = 1000;

        public ClientThread() {

        }

        @Override
        public void run() {
            //start and end are used to calculate the delay of connections for NUMS_REQUEST times
            long start = System.currentTimeMillis();
            for (int i = 0; i < NUMS_REQUEST; i++) {
                connection();
            }
            long end = System.currentTimeMillis();
            System.out.println("Delay: " + (end - start) + "ms");
            delays.add((end - start) + "ms");
        }

        //connect to the server and query() for 1 time
        public static void connection() {
            Socket socket;
            String stockName = randomName();
            System.out.println("The stock you want to query is: " + stockName);
            // Set up input and output streams for the socket
            OutputStreamWriter out;
            BufferedReader in;
            //output stream to send messages to the server
            try {
                socket = new Socket(IP_ADDRESS, PORT);
                out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                query(stockName, out, in);
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //query the price of a stock
    public static void query(String stockName, OutputStreamWriter out, BufferedReader in) throws IOException {
        // Construct the message to send to the server
        String message = "Lookup," + stockName + "\n";
        System.out.println("\n" + message);
        out.write(message);
        out.flush();
        // Read the response from the server
        String response = in.readLine();
        if (response.equals("-2.0")) {
            System.out.println("Error: Stock not found" + "\n");
        } else if (response.equals("0")) {
            System.out.println("Trading suspended for stock: " + stockName + "\n");
        } else {
            double price = Double.parseDouble(response);
            System.out.println("Price of " + stockName + " stock: " + price + "\n");
        }
    }

    //pick a stock name randomly between "GameStart" and "FishCo"
    public static String randomName() {
        Random random = new Random();
        int idx = random.nextInt(2);
        return stockNames.get(idx);
    }
}
