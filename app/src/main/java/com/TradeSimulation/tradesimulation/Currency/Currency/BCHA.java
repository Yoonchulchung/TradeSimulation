package com.TradeSimulation.tradesimulation.Currency.Currency;

public class BCHA implements Currency {

    private final String coinID = "bitcoin-cash-abc-2";
    private final String coinName = "BCHA";

    @Override
    public String getCoinID() {
        return coinID;
    }

    @Override
    public String getCoinName() {
        return this.coinName;
    }
}
