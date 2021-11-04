package com.TradeSimulation.tradesimulation.Trade.position;

import com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.RecyclerView.PositionRecyclerAdapter;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod1;

import java.util.ArrayList;

import static com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.TradingPageFirstFragment.b_b_recyclerView;

public class PositionAdapter {

    public static ArrayList<PositionData> positionData = new ArrayList<PositionData>();
    PositionRecyclerAdapter positionRecyclerAdapter = new PositionRecyclerAdapter();

    public PositionAdapter(String currencyName, Double entryPrice, double entrySize, long entryTime,
                           TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {
        positionData.add(new PositionData(currencyName, entryPrice, entrySize, entryTime,
                tradeMethod, tradeMethod1));

        positionUpdate();

        System.out.println(positionData.get(0));
        System.out.println("Worked!");
    }

    public void positionUpdate() {
        b_b_recyclerView.setAdapter(positionRecyclerAdapter);
    }

    public int getPositionIndex() {
        return 0;
    }


    //Todo:
    //Position에 올라온 데이터를 1분 간격으로 주기적으로 업데이트. Handler통해서 데이터 업데티트.
    //liquidation체크.


}
