package com.TradeSimulation.tradesimulation.JsonParser;

public class JsonCurrentData {

    private final String coinName;
    private final String coinID;
    private final String marketPrice;
    private final String usd_market_cap;
    private final String usd_24h_vol;
    private final String usd_24h_change;
    private final String last_updated_at;

    public JsonCurrentData(String coinName, String coinID, String marketPrice, String usd_market_cap,
                           String usd_24h_vol, String usd_24h_change, String last_updated_at) {
        this.coinName = coinName;
        this.coinID = coinID;
        this.marketPrice = marketPrice;
        this.usd_market_cap = usd_market_cap;
        this.usd_24h_vol = usd_24h_vol;
        this.usd_24h_change = usd_24h_change;
        this.last_updated_at = last_updated_at;
    }

    public String getCoinID() {
        return coinID;
    }

    public String getCoinName() {
        return coinName;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public String getUsd_market_cap() {
        return usd_market_cap;
    }

    public String getUsd_24h_vol() {
        return usd_24h_vol;
    }

    public String getUsd_24h_change() {
        return usd_24h_change;
    }

    public String getLast_updated_at() {
        return last_updated_at;
    }
}
