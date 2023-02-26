package part1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //get the server that you want to connect  IP address and port
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ip address of the server: ");
        String ipAddress = scanner.nextLine();
        System.out.println("Please enter the port number of the server: ");
        int port = scanner.nextInt();
        while(true){
            Socket socket = new Socket(ipAddress, port);
            // Set up input and output streams for the socket
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            System.out.println("input the stock name that you want to lookup" + "\n");
//            Scanner input = new Scanner(System.in);
            String stockName = scanner.next();
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
            socket.close();
        }
    }
}
