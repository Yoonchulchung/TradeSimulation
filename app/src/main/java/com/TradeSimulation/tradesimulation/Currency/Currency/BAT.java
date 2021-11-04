package com.TradeSimulation.tradesimulation.Currency.Currency;

public class BAT implements Currency {

    private final String coinID = "basic-attention-token";
    private final String coinName = "BAT";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }
}
