package io.grpc.stock;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Random;

public class ClientThread implements Runnable {
//    private static final String SERVER_ADDRESS = "localhost:8899";
    private static final String[] STOCKS = {"GameStart", "FishCo", "BoarCo", "MenhirCo"};

    private final StockServiceGrpc.StockServiceBlockingStub blockingStub;

    public ClientThread() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("128.119.243.168", 8899)
                .usePlaintext()
                .build();
        blockingStub = StockServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public void run() {
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            int stockIndex = random.nextInt(4) + 1;
//            int functionIndex = random.nextInt(3) + 1;
//            switch (functionIndex){
//                case 1:
//                    query(randomChooseStock(stockIndex));
//                case 2:
//                    trade(randomChooseStock(stockIndex), random.nextInt(5001), random.nextBoolean());
//                case 3:
//                    update(randomChooseStock(stockIndex));
//            }
//            query(randomChooseStock(stockIndex));
            trade(randomChooseStock(stockIndex), random.nextInt(50), random.nextBoolean());
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public String randomChooseStock(int stockIndex){
        switch (stockIndex){
            case 1:
                return "GameStart";
            case 2:
                return "FishCo";
            case 3:
                return "BoarCo";
            case 4:
                return "MenhirCo";
            default:
                return "";
        }
    }

    public void query(String name) {
        System.out.println("You are calling the query method, the stock name of the query is: " + name);

        StockRequest req = StockRequest.newBuilder().setStockName(name).build();
        StockResponse response;
        try {
            response = blockingStub.queryStock(req);
        } catch (StatusRuntimeException e) {
            //logger
            return;
        }
        System.out.println("the name is: " + response.getStockName() +  " the price is: " + response.getPrice()+ " the trading volume is: " + response.getVolume());
    }

    public void trade(String name, int volume, boolean isBuy) {
        System.out.println("You are calling the trade method, the stock name of the trade is: " + name + "the trade volume is :" + volume);
        TradeRequest req = TradeRequest.newBuilder().setStockName(name).setTradeVolume(volume).setIsBuy(isBuy).build();
        TradeResponse response;
        try {
            response = blockingStub.tradeStock(req);
        } catch (StatusRuntimeException e) {
            //logger
            return;
        }
        if (response.getStatus() == 1) {
            System.out.println("Your trade is successful.");
        } else if (response.getStatus() == 0){
            System.out.println("Trade for: " + name + " is suspended.");
        } else {
            System.out.println("Please enter a correct stock name.");
        }
    }

    public void update(String name) {
        Random random = new Random();
        double price = Math.round(-20.00 + 200.00 * random.nextDouble()) * 1.00;
        System.out.println("You are calling the update method, the stock name of the update is: " + name + "the stock price is :" + price);
        UpdatePriceRequest req = UpdatePriceRequest.newBuilder().setStockName(name).setPrice(price).build();
        UpdatePriceResponse response;
        try {
            response = blockingStub.updatePrice(req);
        } catch (StatusRuntimeException e) {
            return;
        }
        if (response.getStatus() == 1) {
            System.out.println(name + ": " + price + ", successful");
        } else if (response.getStatus() == -2){
            System.out.println("The price can not be negative");
        } else {
            System.out.println("Please enter a correct stock name.");
        }
    }

}
