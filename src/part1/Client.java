package part1;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the ip address of the server: ");
            String ipAddress = scanner.nextLine();
            System.out.println("Please enter the port number of the server: ");
            int port = scanner.nextInt();
            Socket socket = new Socket(ipAddress, port);
            // Set up input and output streams for the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            // Construct the message to send to the server
            System.out.println("Please enter the stock name you want to look up: ");
            String stockName = scanner.next();
            String message = "Lookup," + stockName + "\n";
            System.out.println("\n" + message);
            //send msg to the server
            out.println(message);
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
            socket.close();
        }
    }
}
