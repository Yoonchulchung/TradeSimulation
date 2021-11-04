package com.TradeSimulation.tradesimulation.Trade.position;

import com.TradeSimulation.tradesimulation.Calculate.CalculateCrossLong;
import com.TradeSimulation.tradesimulation.Calculate.CalculateCrossShort;
import com.TradeSimulation.tradesimulation.Calculate.CalculateIsolatedLong;
import com.TradeSimulation.tradesimulation.Calculate.CalculateIsolatedShort;
import com.TradeSimulation.tradesimulation.Calculate.CalculateLongShortAdapter;
import com.TradeSimulation.tradesimulation.Currency.EnableData;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod1;

import static com.TradeSimulation.tradesimulation.Currency.EnabledCurrencyList.enabledCurrencyList;
import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonCurrentData;

public class PositionData {

    private final String currencyName;
    private final Double entryPrice;
    private final double entrySize;
    private final long entryTime;
    private final TradeMethod tradeMethod;
    private final TradeMethod1 tradeMethod1;
    CalculateLongShortAdapter calculateLongShortAdapter = CalculateLongShortAdapter.getInstance();
    private int arrayIndex = 0;

    public PositionData(String currencyName, Double entryPrice, double entrySize, long entryTime,
                        TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {
        this.currencyName = currencyName;
        this.entryPrice = entryPrice;
        this.entrySize = entrySize;
        this.entryTime = entryTime;
        this.tradeMethod = tradeMethod;
        this.tradeMethod1 = tradeMethod1;

        for (EnableData a : enabledCurrencyList) {
            if (a.getCryptoName().equals(currencyName)) {
                break;
            }
            arrayIndex = arrayIndex + 1;
        }

        if (tradeMethod1 == TradeMethod1.Isolate && tradeMethod == TradeMethod.LONG) {
            calculateLongShortAdapter.setLongShort(new CalculateIsolatedLong());
        } else if (tradeMethod1 == TradeMethod1.Isolate && tradeMethod == TradeMethod.SHORT) {
            calculateLongShortAdapter.setLongShort(new CalculateIsolatedShort());
        } else if (tradeMethod1 == TradeMethod1.Cross && tradeMethod == TradeMethod.LONG) {
            calculateLongShortAdapter.setLongShort(new CalculateCrossLong());
        } else if (tradeMethod1 == TradeMethod1.Cross && tradeMethod == TradeMethod.SHORT) {
            calculateLongShortAdapter.setLongShort(new CalculateCrossShort());
        } else {

        }
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public Double getEntryPrice() {
        return entryPrice;
    }

    public double getEntrySize() {
        return entrySize;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public double getUnrealizedPNL() {
        return calculateLongShortAdapter.getUnrealizedPnL(entryPrice, entrySize,
                Double.parseDouble(jsonCurrentData.get(arrayIndex).getMarketPrice()));
    }

    public TradeMethod getTradeMethod() {
        return tradeMethod;
    }

    public int getLiquidationPrice() {
        return 0;
    }
}
