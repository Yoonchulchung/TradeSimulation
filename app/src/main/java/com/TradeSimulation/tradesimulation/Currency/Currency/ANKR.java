package com.TradeSimulation.tradesimulation.Currency.Currency;

public class ANKR implements Currency {

    private final String coinID = "ankr";
    private final String coinName = "ANKR";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
