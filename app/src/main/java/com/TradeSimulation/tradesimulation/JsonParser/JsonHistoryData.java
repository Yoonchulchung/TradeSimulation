package com.TradeSimulation.tradesimulation.JsonParser;

import java.util.Date;

public class JsonHistoryData {

    private final Date Date;
    private final double Open;
    private final double high;
    private final double low;
    private final double close;

    JsonHistoryData(Object Date, Object Open, Object high, Object low, Object close) {
        long dv = (long) Date;
        java.util.Date df = new java.util.Date(dv);

        this.Date = df;
        this.Open = (double) Open;
        this.high = (double) high;
        this.low = (double) low;
        this.close = (double) close;
    }

    public Date getDate() {
        return Date;
    }

    public float getOpen() {
        return (float) Open;
    }

    public float getHigh() {
        return (float) high;
    }

    public float getLow() {
        return (float) low;
    }

    public float getClose() {
        return (float) close;
    }

}
