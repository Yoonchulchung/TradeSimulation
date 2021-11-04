package com.TradeSimulation.tradesimulation.Currency.Currency;

public class BCH implements Currency {

    private final String coinID = "binance-peg-bitcoin-cash";
    private final String coinName = "BCH";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }
}
