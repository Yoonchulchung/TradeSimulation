package com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView.RecentViewData;
import com.TradeSimulation.tradesimulation.R;

import java.util.ArrayList;

public class FirstPageSecondFragment extends Fragment {

    private ArrayList<RecentViewData> recentViewData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.a_first_page_b_second_fragment, container, false);

        recentViewData = new ArrayList<RecentViewData>();

        return rootView;
    }
}
