package com.TradeSimulation.tradesimulation.Trade;

import com.TradeSimulation.tradesimulation.Calculate.Calculate;

public class TradeSystem {

    Calculate calculate = Calculate.getInstance();

    public TradeSystem() {

    }

    public boolean checkStatus(Double startPrice, double amount) {

        if (calculate.startCalculateTrade(startPrice, amount) <= 0) {
            //Toast.makeText(mainActivity.getApplicationContext(), languageAdapter.notEnoughMoney(), Toast.LENGTH_SHORT).show();
            calculate.recoverCalculateTrade();
            return false;
        } else {
            //Toast.makeText(mainActivity.getApplicationContext(), languageAdapter.purchase(), Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public void initTrade() {

    }

}
