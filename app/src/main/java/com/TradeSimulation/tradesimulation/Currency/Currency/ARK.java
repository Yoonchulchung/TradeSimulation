package com.TradeSimulation.tradesimulation.Currency.Currency;

public class ARK implements Currency {

    private final String coinID = "ark";
    private final String coinName = "ARK";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }
}
