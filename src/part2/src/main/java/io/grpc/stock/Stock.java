package io.grpc.stock;

public class Stock {
    private String name;
    private double price;
    private int tradingVolume;

    public Stock(String name, double price, int tradingVolume){
        this.name = name;
        this.price = price;
        this.tradingVolume = tradingVolume;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getTradingVolume() {
        return tradingVolume;
    }
    public void setTradingVolume(int tradingVolume) {
        this.tradingVolume = tradingVolume;
    }
}
