package part1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        while(true){
            Scanner input = new Scanner(System.in);
            String stockName = input.next();
            String hostname = "localhost"; // Change this to the hostname or IP address of the server
            int port = 8888; // Change this to the port number the server is listening on
            Socket socket = new Socket(hostname, port);
            // Set up input and output streams for the socket
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            // Construct the message to send to the server
            String message = "Lookup," + stockName ;
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
            socket.close();
        }
    }
}
