package io.grpc.stock;

import io.grpc.stub.StreamObserver;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ServiceImpl extends StockServiceGrpc.StockServiceImplBase {
    private static final int MAX_TRADING_VOLUME = 10000;

    private final ConcurrentMap<String, Stock> stockMap = new ConcurrentHashMap<>();

    public ServiceImpl() {
        // 初始化股票信息
        stockMap.put("GameStart", new Stock("GameStart",15.39, 0));
        stockMap.put("FishCo", new Stock("FishCo",25.12, 0));
        stockMap.put("BoarCo", new Stock("BoarCo",1.98, 0));
        stockMap.put("MenhirCo", new Stock("MenhirCo",92.93, 0));
    }

    @Override
    public void queryStock(StockRequest req, StreamObserver<StockResponse> responseObserver) {
        String stockName = req.getStockName();
        Stock stock = stockMap.get(stockName);
        System.out.println("I got the stock name that want to query : " + stockName);
        StockResponse response;
        if (stock == null) {
            response = StockResponse.newBuilder().setStockName(stockName).setPrice(-1).setVolume(0).build();
        } else if (stock.getTradingVolume() >= MAX_TRADING_VOLUME) {
            response = StockResponse.newBuilder().setStockName(stockName).setPrice(0).setVolume(0).build();
        } else {
            response = StockResponse.newBuilder().setStockName(stockName).setPrice(stock.getPrice()).setVolume(stock.getTradingVolume()).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void tradeStock(TradeRequest req, StreamObserver<TradeResponse> responseObserver) {
        String stockName = req.getStockName();
        int volume = req.getTradeVolume();
        boolean isBuy = req.getIsBuy();
        Stock stock = stockMap.get(stockName);
        System.out.println("I got the stock : " + stockName + "want to trade :" + volume + " is buy :" + isBuy);
        TradeResponse response;
        if (stock == null) {
            response = TradeResponse.newBuilder().setStatus(-1).build();
        } else {
            if (stock.getTradingVolume() + volume > MAX_TRADING_VOLUME) {
                response = TradeResponse.newBuilder().setStatus(0).build();
            } else {
                stock.setTradingVolume(stock.getTradingVolume() + volume);
                response = TradeResponse.newBuilder().setStatus(1).build();
            }
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updatePrice(UpdatePriceRequest req, StreamObserver<UpdatePriceResponse> responseObserver){
        String stockName = req.getStockName();
        double price = req.getPrice();
        Stock stock = stockMap.get(stockName);
        System.out.println("I got the stock :" + stockName + "want to update the price :" + price );
        if(stock == null){
            responseObserver.onNext(UpdatePriceResponse.newBuilder().setStatus(-1).build());
        }else if(price < 0.0){
            responseObserver.onNext(UpdatePriceResponse.newBuilder().setStatus(-2).build());
        } else{
            stock.setPrice(price);
            stockMap.put(stockName, stock);
            responseObserver.onNext(UpdatePriceResponse.newBuilder().setStatus(1).build());
        }
        responseObserver.onCompleted();
    }
}
