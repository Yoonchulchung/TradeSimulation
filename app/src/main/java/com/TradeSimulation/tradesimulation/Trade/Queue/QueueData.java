package com.TradeSimulation.tradesimulation.Trade.Queue;

import com.TradeSimulation.tradesimulation.Trade.TradeMethod;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod1;

public class QueueData {

    private final String currencyName;
    private final Double entryPrice;
    private final double entrySize;
    private final long entryTime;
    private final TradeMethod tradeMethod;
    private final TradeMethod1 tradeMethod1;
    private final int arrayIndex = 0;

    public QueueData(String currencyName, Double entryPrice, double entrySize, long entryTime, TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {
        this.currencyName = currencyName;
        this.entryPrice = entryPrice;
        this.entrySize = entrySize;
        this.entryTime = entryTime;
        this.tradeMethod = tradeMethod;
        this.tradeMethod1 = tradeMethod1;
    }


}
