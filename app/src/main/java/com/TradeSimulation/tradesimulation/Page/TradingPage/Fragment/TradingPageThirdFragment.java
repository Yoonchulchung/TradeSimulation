package com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.RecyclerView.HistoryAdapter;
import com.TradeSimulation.tradesimulation.R;

public class TradingPageThirdFragment extends Fragment {

    private ViewGroup rootView = null;
    private HistoryAdapter historyAdapter = null;
    private RecyclerView recyclerView = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.b_trading_page_c_fragment_history, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView_trading_page_history);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        System.out.println("!!!");
        if (historyAdapter == null) {
            historyAdapter = new HistoryAdapter();
        } else {

        }
        recyclerView.setAdapter(historyAdapter);

        return rootView;
    }
}
