package com.TradeSimulation.tradesimulation.Currency.Currency;

public class ADA implements Currency {

    private final String coinID = "cardano";
    private final String coinName = "ADA";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return coinName;
    }


}
