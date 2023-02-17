package part1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private static final int MAX_TRADING_VOLUME = 1000;
    private static Map<String, Stock> stockCatalog = new HashMap<>();

    static {
        stockCatalog.put("GameStart", new Stock("GameStart", 10.00));
        stockCatalog.put("FishCo", new Stock("FishCo", 20.00));
    }

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = in.readLine();
            String[] tokens = request.split(",");
            String method = tokens[0];
            String stockName = tokens[1];
            System.out.println("Received request for " + method + " " + stockName);

            switch (method) {
                case "Lookup":
                    double price = lookup(stockName);
                    out.println(price);
                    break;
                default:
                    out.println(-1);
                    break;
            }
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Connection closed");
        } 
        catch (IOException e) {
            System.err.println("Error handling client request: " + e);
        }
    }

    private double lookup(String stockName) {
        Stock stock = stockCatalog.get(stockName);
        if (stock == null) {
            return -2.0;
        } else if (stock.getTradingVolume() >= MAX_TRADING_VOLUME) {
            return 0;
        } else {
            return stock.getPrice();
        }
    }
}
