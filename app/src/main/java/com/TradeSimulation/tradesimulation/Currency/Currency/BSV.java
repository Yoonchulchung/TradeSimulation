package com.TradeSimulation.tradesimulation.Currency.Currency;

public class BSV implements Currency {

    private final String coinID = "bitcoin-cash-sv";
    private final String coinName = "BSV";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }
}
