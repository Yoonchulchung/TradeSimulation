package com.TradeSimulation.tradesimulation.Trade.Queue;

import com.TradeSimulation.tradesimulation.Trade.TradeMethod;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod1;

import java.util.ArrayList;

public class QueueAdapter {

    public static ArrayList<QueueData> queueData = new ArrayList<QueueData>();

    public QueueAdapter(String currencyName, double entryPrice, double entrySize, long entryTime,
                        TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {
        queueData.add(new QueueData(currencyName, entryPrice, entrySize, entryTime,
                tradeMethod, tradeMethod1));
    }
}
