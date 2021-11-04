package com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.JsonParser.JsonCurrentData;
import com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView.CryptoAdapterRecyclerView;
import com.TradeSimulation.tradesimulation.Page.TradingPage.TradingActivity;
import com.TradeSimulation.tradesimulation.R;

import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonCurrentData;

public class FirstPageThirdFragment extends Fragment {

    public static Handler cryptoListHandler = null;
    static CryptoAdapterRecyclerView cryptoAdapterRecyclerView = null;
    static RecyclerView firstRecyclerView = null;
    Bundle bundle = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.a_first_page_c_third_fragment, container, false);

        firstRecyclerView = rootView.findViewById(R.id.CryptoRecycler);
        firstRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        bundle = new Bundle();


        cryptoListHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                if (msg.obj != null) {
                    for (JsonCurrentData a : jsonCurrentData) {
                        if (msg.obj.equals(a.getCoinName())) {
                            Intent intent = new Intent(getContext(), TradingActivity.class);
                            bundle.putString("CurrentCurrency", a.getCoinName());
                            bundle.putString("CurrentPrice", a.getMarketPrice());
                            bundle.putString("Current24H_Vol", a.getUsd_24h_vol());
                            bundle.putString("CurrentCurrencyID", a.getCoinID());
                            intent.putExtras(bundle);

                            startActivity(intent);
                        } else {

                        }
                    }
                } else {

                }
            }
        };

        if (cryptoAdapterRecyclerView == null) {
            cryptoAdapterRecyclerView = new CryptoAdapterRecyclerView();
        } else {

        }
        firstRecyclerView.setAdapter(cryptoAdapterRecyclerView);

        return rootView;
    }

    //실시간 데이터 1분 주기로 refresh
    public static class RefreshListHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                if (cryptoAdapterRecyclerView != null && firstRecyclerView != null) {
                    firstRecyclerView.setAdapter(cryptoAdapterRecyclerView);
                } else {

                }
            }
        }
    }


}
