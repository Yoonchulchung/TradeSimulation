package com.TradeSimulation.tradesimulation.Currency.Currency;

public class ETH implements Currency {

    private final String coinID = "ethereum";
    private final String coinName = "ETH";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
