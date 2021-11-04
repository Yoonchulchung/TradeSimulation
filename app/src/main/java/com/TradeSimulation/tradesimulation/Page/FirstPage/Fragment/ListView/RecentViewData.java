package com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView;

public class RecentViewData {

    private final String cryptoName;
    private final long price;

    public RecentViewData(String cryptoName, long price) {
        this.cryptoName = cryptoName;
        this.price = price;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

}
