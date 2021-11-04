package com.TradeSimulation.tradesimulation.Currency.Currency;

public class AXS implements Currency {

    private final String coinID = "axie-infinity";
    private final String coinName = "AXS";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
