package com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView;

public class GlobalData {

    public String countryName;
    public int index;

    public GlobalData(String countryName, int index) {
        this.countryName = countryName;
        this.index = index;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getIndex() {
        return index;
    }
}
