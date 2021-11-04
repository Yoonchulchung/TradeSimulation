package com.TradeSimulation.tradesimulation.Calculate;

public class CalculateIsolatedShort implements LongShort {

    @Override
    public double getUnrealizedPnL(double entryPrice, double quantity, double marketPrice) {
        return (entryPrice - marketPrice) * quantity;
    }

    @Override
    public double getMaintenanceMargin(double entryPrice, int leverage, int maintenanceMarginRatio) {
        return entryPrice * leverage / (leverage * (1 + maintenanceMarginRatio) - 1);
    }

    @Override
    public boolean checkShortLiquidation(double marketPrice, double maintenanceMargin) {
        return marketPrice > maintenanceMargin;
    }


}
