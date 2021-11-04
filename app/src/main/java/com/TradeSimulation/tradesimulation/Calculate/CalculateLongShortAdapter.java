package com.TradeSimulation.tradesimulation.Calculate;

public class CalculateLongShortAdapter implements LongShort {

    private static CalculateLongShortAdapter calculateLongShortAdapter = null;
    private LongShort longShort;

    private CalculateLongShortAdapter() {

    }

    public static CalculateLongShortAdapter getInstance() {
        if (calculateLongShortAdapter == null) {
            calculateLongShortAdapter = new CalculateLongShortAdapter();
        } else {

        }
        return calculateLongShortAdapter;
    }

    public void setLongShort(LongShort longShort) {
        this.longShort = longShort;
    }


    @Override
    public double getUnrealizedPnL(double entryPrice, double quantity, double marketPrice) {
        return longShort.getUnrealizedPnL(entryPrice, quantity, marketPrice);
    }

    @Override
    public double getMaintenanceMargin(double entryPrice, int leverage, int maintenanceMarginRatio) {
        return longShort.getMaintenanceMargin(entryPrice, leverage, maintenanceMarginRatio);
    }

    @Override
    public boolean checkShortLiquidation(double marketPrice, double maintenanceMargin) {
        return longShort.checkShortLiquidation(marketPrice, maintenanceMargin);
    }
}
