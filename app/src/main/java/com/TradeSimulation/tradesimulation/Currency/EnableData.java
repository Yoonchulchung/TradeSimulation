package com.TradeSimulation.tradesimulation.Currency;

public class EnableData {

    private final String cryptoName;
    private final String cryptoID;

    public EnableData(String cryptoName, String cryptoID) {
        this.cryptoName = cryptoName;
        this.cryptoID = cryptoID;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public String getCryptoID() {
        return cryptoID;
    }

}
