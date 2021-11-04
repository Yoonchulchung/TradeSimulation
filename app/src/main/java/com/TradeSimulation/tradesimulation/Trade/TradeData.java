package com.TradeSimulation.tradesimulation.Trade;

public class TradeData {

    private final String currencyName;
    private final Double entryPrice;
    private final int entrySize;
    private final long entryTime;
    private final int unrealizedPNL;
    private final TradeMethod tradeMethod;
    private final int liquidationPrice;

    public TradeData(String currencyName, double entryPrice, int entrySize, long entryTime,
                     int unrealizedPNL, TradeMethod tradeMethod, int liquidationPrice) {
        this.currencyName = currencyName;
        this.entryPrice = entryPrice;
        this.entrySize = entrySize;
        this.entryTime = entryTime;
        this.unrealizedPNL = unrealizedPNL;
        this.tradeMethod = tradeMethod;
        this.liquidationPrice = liquidationPrice;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Double getEntryPrice() {
        return entryPrice;
    }

    public int getEntrySize() {
        return entrySize;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public int getUnrealizedPNL() {

        return unrealizedPNL;
    }

    public TradeMethod getTradeMethod() {
        return tradeMethod;
    }

    public int getLiquidationPrice() {
        return liquidationPrice;
    }
}
