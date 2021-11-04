package com.TradeSimulation.tradesimulation.Page.TradingPage;

public class CurrentState {

    private static CurrentState currentState = null;
    private String currencyName;
    private String marketPrice;

    private CurrentState() {

    }

    public static CurrentState getInstance() {
        if (currentState == null) {
            currentState = new CurrentState();
        } else {

        }

        return currentState;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }
}
