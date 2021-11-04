package com.TradeSimulation.tradesimulation.JsonParser;

import androidx.annotation.NonNull;

import com.TradeSimulation.tradesimulation.Connection.ConnectionMethod;
import com.TradeSimulation.tradesimulation.Currency.CurrencyAdapter;
import com.TradeSimulation.tradesimulation.Currency.EnableData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.TradeSimulation.tradesimulation.Currency.EnabledCurrencyList.enabledCurrencyList;


public class JsonParser {

    public static ArrayList<JsonCurrentData> jsonCurrentData = new ArrayList<JsonCurrentData>();
    public static ArrayList<JsonHistoryData> jsonHistoryData = new ArrayList<JsonHistoryData>();

    private CurrencyAdapter currencyAdapter = null;
    private ConnectionMethod connectionMethod = null;
    private int counter = 0;

    public JsonParser(@NonNull ConnectionMethod connectionMethod) {
        this.connectionMethod = connectionMethod;
        currencyAdapter = CurrencyAdapter.getInstance();
    }

    public void StartParsing(String object) {
        if (connectionMethod == ConnectionMethod.LiveConnection) {
            try {
                JSONObject jsonObject = new JSONObject(object);
                for (EnableData enableData : enabledCurrencyList) {
                    //기존 CoinID를 통해 얻은 정도 확인.
                    JSONObject subJsonObject = jsonObject.getJSONObject(enableData.getCryptoID());

                    //데이터가 있는지 확인하고 있을시 클리어한다.
                    if (counter == 0) {
                        jsonCurrentData.clear();
                        counter++;
                    } else {

                    }

                    //인터넷을 통해 얻은 데이터를 저장
                    jsonCurrentData.add(new JsonCurrentData(enableData.getCryptoName(),
                            enableData.getCryptoID(),
                            subJsonObject.getString("usd"),
                            subJsonObject.getString("usd_market_cap"),
                            subJsonObject.getString("usd_24h_vol"),
                            subJsonObject.getString("usd_24h_change"),
                            subJsonObject.getString("last_updated_at")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (connectionMethod == ConnectionMethod.HistoryConnection) {
            jsonHistoryData.clear();
            try {
                JSONArray jsonArray = new JSONArray(object);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONArray jsonArray1 = jsonArray.getJSONArray(i);

                    jsonHistoryData.add(new JsonHistoryData(jsonArray1.get(0),
                            jsonArray1.get(1),
                            jsonArray1.get(2),
                            jsonArray1.get(3),
                            jsonArray1.get(4)));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
    }

}
