package com.TradeSimulation.tradesimulation.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    public String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String getTime = dateFormat.format(date);
        return getTime;
    }

}
