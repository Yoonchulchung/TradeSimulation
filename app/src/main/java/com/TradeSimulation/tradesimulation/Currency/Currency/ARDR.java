package com.TradeSimulation.tradesimulation.Currency.Currency;

public class ARDR implements Currency {

    private final String coinID = "ardor";
    private final String coinName = "ARDR";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }

}
