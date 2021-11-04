package com.TradeSimulation.tradesimulation.Currency.Currency;

public class AQT implements Currency {

    private final String coinID = "aqt-token";
    private final String coinName = "AQT";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
