package com.TradeSimulation.tradesimulation.Connection;

import android.os.Handler;

import com.TradeSimulation.tradesimulation.Currency.ContextCurrency;
import com.TradeSimulation.tradesimulation.Currency.EnableData;
import com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.FirstPageThirdFragment;

import static com.TradeSimulation.tradesimulation.Currency.EnabledCurrencyList.enabledCurrencyList;

public class ConnectionAdapter extends Thread {

    private final Handler handler = new FirstPageThirdFragment.RefreshListHandler();
    private Connector connector = null;
    private StringBuilder stringBuilder = null;
    private Runnable runnable = null;
    private ContextCurrency contextCurrency = null;

    private String uri = null;
    private String appendix = null;
    private String url = null;

    public ConnectionAdapter() {
        contextCurrency = ContextCurrency.getInstance();
    }


    public void Connect(ConnectionMethod connectionMethod) {

        //과거 데이터
        if (connectionMethod == ConnectionMethod.HistoryConnection) {
            uri = "https://api.coingecko.com/api/v3/coins/";
            appendix = "/ohlc?vs_currency=usd&days=30";

            if (contextCurrency.getCurrencyID() == null) {
                url = uri + "bitcoin" + appendix;
            } else {
                url = uri + contextCurrency.getCurrencyID() + appendix;
            }


            connector = new Connector(connectionMethod, url);
            connector.start();
        }

        //실시간 데이터
        else if (connectionMethod == ConnectionMethod.LiveConnection) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    uri = "https://api.coingecko.com/api/v3/simple/price?ids=";
                    appendix = "&vs_currencies=usd&include_market_cap=true&include_24hr_vol=true&include_24hr_change=true&include_last_updated_at=true";
                    stringBuilder = new StringBuilder();

                    for (EnableData a : enabledCurrencyList) {
                        stringBuilder.append(a.getCryptoID()).append(",");
                    }

                    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));

                    url = uri + stringBuilder + appendix;

                    //연결 시작
                    connector = new Connector(connectionMethod, url);
                    connector.start();

                    //데이터 받아올 때마다 jsonCurrentData refresh해서 데이터 뿌려준다.
                    handler.sendEmptyMessage(1);

                    //1분 주기로 업데이트 하도록 설정.
                    handler.postDelayed(runnable, 60000);
                }
            };
            handler.post(runnable);
        } else {

        }
    }
}
