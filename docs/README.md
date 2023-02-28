# Part 1
## Quick Start
First you should change your root directory to part1
on sever side:
```
javac -d ./ Client.java ClientHandler.java PoolWorker.java Stock.java StockServer.java ThreadPool.java
```
```
java part1.StockServer
```

![image-20230227112934940](./img/image-20230227112934940.png)

on client side:
```
javac -d ./ Client.java ClientHandler.java PoolWorker.java Stock.java StockServer.java ThreadPool.java
```
```
java part1.Client
```

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
./build/install/part2/bin/stock-server
```

From another terminal, run the client:

```
./build/install/part2/bin/stock-client
```
