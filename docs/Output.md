# Part one

on sever side:

1. `$ javac -d Client.java ClientHandler.java PoolWorker.java Stock.java StockServer.java ThreadPool.java`

2. `$ java part1.StockServer`

 ![image-20230227112934940](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227112934940.png)

on client side:

1. `$ javac -d Client.java ClientHandler.java PoolWorker.java Stock.java StockServer.java ThreadPool.java`
2. `$ java part1.Client`

![image-20230227113056231](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227113056231.png)

3. enter the ip address of the server

![image-20230227113158734](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227113158734.png)



**Output**:

On the server side, it receives requests from clients. On the terminal, for each request, it will show the ip address of the client, the query stock name and a notifition of close connection.

![image-20230227121846575](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227121846575.png)

On the client side, it will show the message sent to the server, the result from the server and the total delay of each client for sending 1000 request to the server.

![image-20230227122144260](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227122144260.png)