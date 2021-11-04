package com.TradeSimulation.tradesimulation.Calculate;

public interface LongShort {

    double getUnrealizedPnL(double entryPrice, double quantity, double marketPrice);

    double getMaintenanceMargin(double entryPrice, int leverage, int maintenanceMarginRatio);

    boolean checkShortLiquidation(double marketPrice, double maintenanceMargin);

}
