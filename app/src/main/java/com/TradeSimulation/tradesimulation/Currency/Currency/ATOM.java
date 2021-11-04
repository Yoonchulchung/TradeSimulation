package com.TradeSimulation.tradesimulation.Currency.Currency;

public class ATOM implements Currency {

    private final String coinID = "cosmos";
    private final String coinName = "ATOM";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
