# Part one

**Output**:

On the server side, it receives requests from clients. On the terminal, for each request, it will show the ip address of the client, the query stock name and a notifition of close connection.

![image-20230227121846575](./img/image-20230227121846575.png)

On the client side, it will show the message sent to the server, the result from the server and the total delay of each client for sending 1000 request to the server.

![image-20230227122144260](./img/image-20230227122144260.png)

# Part two

**OutPut**
1. When the server side is started, the terminal will display the corresponding IP address and service port
   ![part2-2](./img/part2-2.png)
2. After starting the client, you should enter the corresponding IP address and port number to get a connection to the server
   ![part2-3](./img/part2-3.png)
3. 1000 connections will then be made while simulating 5 clients concurrently accessing the server with random commands using a thread pool
4. Client: The last number indicates the total latency after the last thread is finished
   ![part2-4](./img/part2-4.png)
5. Server: Logging request information from the client
   ![part2-5](./img/part2-5.png)