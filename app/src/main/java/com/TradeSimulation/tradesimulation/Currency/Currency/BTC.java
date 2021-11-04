package com.TradeSimulation.tradesimulation.Currency.Currency;

public class BTC implements Currency {

    private final String coinID = "bitcoin";
    private final String coinName = "BTC";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}

