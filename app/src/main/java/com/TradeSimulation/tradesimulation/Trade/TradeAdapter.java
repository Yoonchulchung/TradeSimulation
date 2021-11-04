package com.TradeSimulation.tradesimulation.Trade;

import android.os.Handler;

import com.TradeSimulation.tradesimulation.Currency.EnableData;
import com.TradeSimulation.tradesimulation.Trade.Queue.QueueAdapter;
import com.TradeSimulation.tradesimulation.Trade.position.PositionAdapter;
import com.TradeSimulation.tradesimulation.User.UserInfo;

import static com.TradeSimulation.tradesimulation.Currency.EnabledCurrencyList.enabledCurrencyList;
import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonCurrentData;

public class TradeAdapter {

    private static TradeAdapter tradeAdapter = null;
    private final Handler handler = new Handler();
    private TradeSystem tradeSystem = null;
    private Runnable runnable = null;
    private UserInfo userInfo = null;


    private TradeAdapter() {
        if (tradeSystem == null) {
            tradeSystem = new TradeSystem();
            userInfo = UserInfo.getInstance();
        } else {

        }
    }

    public static TradeAdapter getInstance() {
        if (tradeAdapter == null) {
            tradeAdapter = new TradeAdapter();
        }

        return tradeAdapter;
    }

    //Trade 시작!
    public void initiateTrade(String currencyName, double entryPrice, double entrySize,
                              TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {
        //Todo: 
        //거래가 시작될때까지 무한 루프로 돌리기
        //checkTrade에서 entryMarketPrice 값 바뀌는 버그 수정

        if (tradeSystem.checkStatus(entryPrice, entrySize)) {
            checkTrade(currencyName, entryPrice, entrySize, tradeMethod, tradeMethod1);
        } else {
            //Invalid 하다 표시.
        }
    }

    //Trade 종료
    public void closeTrade(String currencyName, long time) {

    }

    public int checkIndex(String currencyName) {
        int index = 0;
        for (EnableData a : enabledCurrencyList) {
            if (a.getCryptoName().equals(currencyName)) {
                break;
            }
            index++;
        }
        return index;
    }

    public void checkTrade(String currencyName, double entryPrice, double entrySize,
                           TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {
        final double entryMarketPrice = Double.parseDouble(
                jsonCurrentData.get(checkIndex(currencyName)).getMarketPrice());

        runnable = new Runnable() {
            @Override
            public void run() {
                int index = 0;

                double marketPrice = Double.parseDouble(
                        jsonCurrentData.get(checkIndex(currencyName)).getMarketPrice());

                //데이터 비교 특성상 같은 값이 나오는 경우는 없다
                if (entryPrice > entryMarketPrice) {
                    if (entryPrice <= marketPrice) {
                        addPosition(currencyName, entryPrice, entrySize, tradeMethod, tradeMethod1);
                    } else {
                        if (index == 0) {
                            addQueue(currencyName, entryPrice, entrySize, 10, tradeMethod, tradeMethod1);
                            index++;
                        }
                        handler.postDelayed(runnable, 60000);
                    }
                } else if (entryPrice < entryMarketPrice) {
                    if (entryPrice >= marketPrice) {
                        addPosition(currencyName, entryPrice, entrySize, tradeMethod, tradeMethod1);
                    } else {
                        if (index == 0) {
                            addQueue(currencyName, entryPrice, entrySize, 10, tradeMethod, tradeMethod1);
                            index++;
                        }
                        handler.postDelayed(runnable, 60000);
                    }
                } else if (entryPrice == entryMarketPrice) {
                    addPosition(currencyName, entryPrice, entrySize, tradeMethod, tradeMethod1);
                } else {

                }
            }
        };

        runnable.run();
    }

    public void addPosition(String currencyName, double entryPrice, double entrySize,
                            TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {

        //거래 position 등록
        PositionAdapter positionAdapter = new PositionAdapter(
                currencyName, entryPrice, entrySize, System.currentTimeMillis(),
                tradeMethod, tradeMethod1);

        //거래 데이터 저장소에 등록
        /*
        repository.insert(new UserDataBase(String.valueOf(System.currentTimeMillis()),
                "Hello",
                3232,
                currencyName,
                entrySize,
                entryPrice,
                String.valueOf(userInfo.getUserCharge())));


         */

    }

    public void addQueue(String currencyName, double entryPrice, double entrySize, long time,
                         TradeMethod tradeMethod, TradeMethod1 tradeMethod1) {

        //Todo:
        // 대기열에 값이 들어 있으면, 대기 등록을 하지 못하도록 하는 프로세스 정의.

        //대기열에 등록
        QueueAdapter queueAdapter = new QueueAdapter(currencyName, entryPrice, entrySize,
                time, tradeMethod, tradeMethod1);
    }

    public void deleteQue(String currencyName, long time) {
        //Todo:
        // 거래등록이 되면, 대기열에 들어있는 값을 제거
    }

    public void deletePosition(String currencyName, long time) {
        //Todo:
        // 거래가 종료되면, 등록된 거래열에서 제거
    }


}


