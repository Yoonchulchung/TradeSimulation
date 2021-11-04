package com.TradeSimulation.tradesimulation.Calculate;

public class CalculateIsolatedLong implements LongShort {

    @Override
    public double getUnrealizedPnL(double entryPrice, double quantity, double marketPrice) {
        return (marketPrice - entryPrice) * quantity;
    }

    @Override
    public double getMaintenanceMargin(double entryPrice, int leverage, int maintenanceMarginRatio) {
        return entryPrice * leverage / (leverage * (1 - maintenanceMarginRatio) + 1);
    }

    @Override
    public boolean checkShortLiquidation(double marketPrice, double maintenanceMargin) {
        return marketPrice < maintenanceMargin;
    }
}
