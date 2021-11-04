package com.TradeSimulation.tradesimulation.Currency;

import com.TradeSimulation.tradesimulation.Currency.Currency.Currency;

public class CurrencyAdapter {

    static public CurrencyAdapter currencyAdapter = null;
    private Currency currency = null;

    private CurrencyAdapter() {

    }

    public static CurrencyAdapter getInstance() {
        if (currencyAdapter == null) {
            currencyAdapter = new CurrencyAdapter();
        } else {

        }
        return currencyAdapter;
    }

    //이 메소드를 이용해서 Price 설정
    public void setCurrencyAdapter(Currency currency) {
        this.currency = currency;
    }

    public String getCoinName() {
        return currency.getCoinName();
    }

    public String getCoinID() {
        return currency.getCoinID();
    }

    public Currency getCurrency() {
        return currency;
    }

}
