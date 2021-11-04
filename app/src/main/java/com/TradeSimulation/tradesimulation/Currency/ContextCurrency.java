package com.TradeSimulation.tradesimulation.Currency;

public class ContextCurrency {

    private static ContextCurrency contextCurrency = null;
    private String currencyName = null;
    private String currencyID = null;
    private String marketPrice;

    private ContextCurrency() {

    }

    public static ContextCurrency getInstance() {
        if (contextCurrency == null) {
            contextCurrency = new ContextCurrency();
        } else {

        }
        return contextCurrency;
    }

    public void setCurrency(String currencyName, String currencyID) {
        this.currencyName = currencyName;
        this.currencyID = currencyID;
    }

    public String getCurrencyName() {

        return currencyName;
    }

    public String getCurrencyID() {
        return currencyID;
    }
}
