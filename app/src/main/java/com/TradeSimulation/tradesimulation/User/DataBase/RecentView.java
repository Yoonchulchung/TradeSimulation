package com.TradeSimulation.tradesimulation.User.DataBase;

public class RecentView {

    private final String cryptoName;

    RecentView(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public String getCryptoName() {
        return cryptoName;
    }
}
