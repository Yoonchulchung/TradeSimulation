package com.TradeSimulation.tradesimulation.Calculate;

import static com.TradeSimulation.tradesimulation.User.UserInfo.userCharge;

public class CalculateMarket {

    public double getTotalSize(double marketPrice, int leverage, int sizeRatio) {
        return userCharge * sizeRatio / marketPrice * leverage;
    }

    public double getMarketSize(byte percent, double marketPrice, int leverage) {
        //25
        if (percent == (byte) 11001) {
            return userCharge * 0.25 / marketPrice * leverage;
        }
        //50
        else if (percent == (byte) 110010) {
            return userCharge * 0.5 / marketPrice * leverage;
        }
        //75
        else if (percent == (byte) 1001011) {
            return userCharge * 0.75 / marketPrice * leverage;
        }
        //100
        else if (percent == (byte) 1100100) {
            return userCharge / marketPrice * leverage;
        } else {
            return 0;
        }
    }


    public double getCost(double marketPrice, double entrySize) {
        return marketPrice * entrySize;
    }

}
