# Part One

On the server side, the size of the thread pool is 5. The client side builds variable threads to simulate multiple clients (5, 4, 3, 2, 1). Each client requests for 1000 times.

1. 5 clients, 1000 requests/client:

![image-20230227113625273](./img/image-20230227113625273.png)

2. 4 clients, 1000 requests/client:

<img src="./img/image-20230227114459723.png" alt="image-20230227114459723" style="zoom:120%;" />

3. 3 clients, 1000 requests/client:

<img src="/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227115646642.png" alt="image-20230227115646642" style="zoom:150%;" />

4. 2 clients, 1000 requests/client:

<img src="/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227115020163.png" alt="image-20230227115020163" style="zoom:150%;" />

5. 1 client, 1000 requests/client:

<img src="/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227115222433.png" alt="image-20230227115222433" style="zoom:150%;" />



If the size of the thread pool of the server is set to be 3.

1. 5 clients, 1000 requests/client:

![image-20230227120217552](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227120217552.png)

2. 4 clients, 1000 requests/client:

![image-20230227120405657](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227120405657.png)

3. 3 clients, 1000 requests/client:

![image-20230227120541467](/Users/richardzhao/Library/Application Support/typora-user-images/image-20230227120541467.png)


