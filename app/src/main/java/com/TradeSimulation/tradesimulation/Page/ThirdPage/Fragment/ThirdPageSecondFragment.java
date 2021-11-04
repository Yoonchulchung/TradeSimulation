package com.TradeSimulation.tradesimulation.Page.ThirdPage.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.TradeSimulation.tradesimulation.R;

public class ThirdPageSecondFragment extends Fragment {

    private ViewGroup rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.c_history_page_a_fragment_user_info, container, false);

        return rootView;
    }
}
