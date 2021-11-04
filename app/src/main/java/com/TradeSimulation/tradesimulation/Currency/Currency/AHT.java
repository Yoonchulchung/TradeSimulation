package com.TradeSimulation.tradesimulation.Currency.Currency;

public class AHT implements Currency {

    private final String coinID = "ahatoken";
    private final String coinName = "AHT";


    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
