package com.TradeSimulation.tradesimulation.Currency;

import com.TradeSimulation.tradesimulation.Currency.Currency.ADA;
import com.TradeSimulation.tradesimulation.Currency.Currency.AHT;
import com.TradeSimulation.tradesimulation.Currency.Currency.ANKR;
import com.TradeSimulation.tradesimulation.Currency.Currency.AQT;
import com.TradeSimulation.tradesimulation.Currency.Currency.ARDR;
import com.TradeSimulation.tradesimulation.Currency.Currency.ARK;
import com.TradeSimulation.tradesimulation.Currency.Currency.ATOM;
import com.TradeSimulation.tradesimulation.Currency.Currency.AXS;
import com.TradeSimulation.tradesimulation.Currency.Currency.BAT;
import com.TradeSimulation.tradesimulation.Currency.Currency.BCH;
import com.TradeSimulation.tradesimulation.Currency.Currency.BCHA;
import com.TradeSimulation.tradesimulation.Currency.Currency.BORA;
import com.TradeSimulation.tradesimulation.Currency.Currency.BSV;
import com.TradeSimulation.tradesimulation.Currency.Currency.BTC;
import com.TradeSimulation.tradesimulation.Currency.Currency.Currency;
import com.TradeSimulation.tradesimulation.Currency.Currency.ETH;

import java.util.ArrayList;

public class EnabledCurrencyList {

    public static ArrayList<EnableData> searchedList = null;
    public static ArrayList<EnableData> enabledCurrencyList = null;
    private static EnabledCurrencyList currencyList;
    private CurrencyAdapter currencyAdapter = null;

    private EnabledCurrencyList() {

    }

    public static EnabledCurrencyList getInstance() {
        if (currencyList == null) {
            currencyList = new EnabledCurrencyList();

            currencyList.enableCurrency(new ADA());
            currencyList.enableCurrency(new AHT());
            currencyList.enableCurrency(new ANKR());
            currencyList.enableCurrency(new AQT());
            currencyList.enableCurrency(new ARDR());
            currencyList.enableCurrency(new ARK());
            currencyList.enableCurrency(new ATOM());
            currencyList.enableCurrency(new AXS());
            currencyList.enableCurrency(new BAT());
            currencyList.enableCurrency(new BCH());
            currencyList.enableCurrency(new BCHA());
            currencyList.enableCurrency(new BORA());
            currencyList.enableCurrency(new BSV());
            currencyList.enableCurrency(new BTC());
            currencyList.enableCurrency(new ETH());
        } else {

        }
        return currencyList;
    }

    public void enableCurrency(Currency currency) {
        if (currencyAdapter == null || enabledCurrencyList == null) {
            currencyAdapter = CurrencyAdapter.getInstance();
            enabledCurrencyList = new ArrayList<EnableData>();
        } else {

        }

        currencyAdapter.setCurrencyAdapter(currency);
        enabledCurrencyList.add(new EnableData(currencyAdapter.getCoinName(),
                currencyAdapter.getCoinID()));
    }

    //첫번째 액티비티에서 검색할때 여기에 저장
    public void setSearchArray(Currency currency) {
        if (currencyAdapter == null || searchedList == null) {
            currencyAdapter = CurrencyAdapter.getInstance();
            searchedList = new ArrayList<EnableData>();
        } else {

        }
        currencyAdapter.setCurrencyAdapter(currency);
        searchedList.add(new EnableData(currencyAdapter.getCoinName(),
                currencyAdapter.getCoinID()));
    }


}
