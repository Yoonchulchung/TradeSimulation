package com.TradeSimulation.tradesimulation.Currency.Currency;

public class BORA implements Currency {

    private final String coinID = "bora";
    private final String coinName = "BORA";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
