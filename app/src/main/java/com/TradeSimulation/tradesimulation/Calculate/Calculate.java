package com.TradeSimulation.tradesimulation.Calculate;

import com.TradeSimulation.tradesimulation.User.UserInfo;

public class Calculate {

    public static Calculate calculate = null;
    UserInfo userInfo = UserInfo.getInstance();
    private double totalPrice = 0;

    private Calculate() {

    }

    public static Calculate getInstance() {
        if (calculate == null) {
            calculate = new Calculate();
        } else {

        }
        return calculate;
    }

    public double startCalculateTrade(double entryPrice, double entrySize) {
        totalPrice = entryPrice * entrySize;
        userInfo.setUserCharge(userInfo.getUserCharge() - totalPrice);
        return userInfo.getUserCharge();
    }

    public void recoverCalculateTrade() {
        userInfo.setUserCharge(userInfo.getUserCharge() + totalPrice);
    }

    public double getTotalPrice(double entryPrice, double entrySize) {
        return entryPrice * entrySize;
    }

    public int getROE(int unrealizedPNL, int initialMargin) {
        return unrealizedPNL / initialMargin;
    }


}
