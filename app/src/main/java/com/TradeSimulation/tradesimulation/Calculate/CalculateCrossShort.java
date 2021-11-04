package com.TradeSimulation.tradesimulation.Calculate;

public class CalculateCrossShort implements LongShort {
    @Override
    public double getUnrealizedPnL(double entryPrice, double quantity, double marketPrice) {
        return 0;
    }

    @Override
    public double getMaintenanceMargin(double entryPrice, int leverage, int maintenanceMarginRatio) {
        return 0;
    }

    @Override
    public boolean checkShortLiquidation(double marketPrice, double maintenanceMargin) {
        return false;
    }
}
