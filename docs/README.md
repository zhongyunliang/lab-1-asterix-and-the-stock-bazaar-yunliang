# Part 1
on sever side:

1. `$ javac -d Client.java ClientHandler.java PoolWorker.java Stock.java StockServer.java ThreadPool.java`

2. `$ java part1.StockServer`

![image-20230227112934940](./img/image-20230227112934940.png)

on client side:

1. `$ javac -d Client.java ClientHandler.java PoolWorker.java Stock.java StockServer.java ThreadPool.java`
2. `$ java part1.Client`

![image-20230227113056231](./img/image-20230227113056231.png)

3. enter the ip address of the server

![image-20230227113158734](./img/image-20230227113158734.png)

# Part2
## Quick Start
First you should change your root directory to part2


Build project:

```
./gradlew installDist
```

Run the server:

```
./build/install/part2/bin/hello-world-server
```

From another terminal, run the client:

```
./build/install/part2/bin/hello-world-client
```
