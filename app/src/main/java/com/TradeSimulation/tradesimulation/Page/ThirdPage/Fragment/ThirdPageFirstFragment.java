package com.TradeSimulation.tradesimulation.Page.ThirdPage.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.RecyclerView.PositionRecyclerAdapter;
import com.TradeSimulation.tradesimulation.R;

import static com.TradeSimulation.tradesimulation.User.UserInfo.userCharge;

public class ThirdPageFirstFragment extends Fragment {

    public static RecyclerView walletRecyclerView = null;
    private ViewGroup rootView;
    private TextView totalBalance;
    private TextView totalUnrealizedPnL;
    private TextView totalInterest;
    private TextView marginRatio;
    private TextView position;
    private TextView queue;
    private double balance;
    //state = true equals position
    //state = false equals queue
    private boolean state = true;
    private PositionRecyclerAdapter positionRecyclerAdapter = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.c_history_page_a_fragment_user_info, container, false);

        getViewObject();
        setViewObject();

        walletRecyclerView = rootView.findViewById(R.id.viewPager_c_a_position);
        walletRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        if (positionRecyclerAdapter == null) {
            positionRecyclerAdapter = new PositionRecyclerAdapter();
        } else {

        }

        walletRecyclerView.setAdapter(positionRecyclerAdapter);


        changeState(state);

        position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState(state = true);
            }
        });

        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeState(state = false);
            }
        });


        return rootView;
    }

    public void getViewObject() {
        totalBalance = rootView.findViewById(R.id.textView_c_a_totalBalance);
        totalInterest = rootView.findViewById(R.id.textView_c_a_totalInterest);
        totalUnrealizedPnL = rootView.findViewById(R.id.textView_c_a_totalUnrealizedPNL);
        marginRatio = rootView.findViewById(R.id.textView_c_a_marginRatio);
        position = rootView.findViewById(R.id.textView_c_a_position);
        queue = rootView.findViewById(R.id.textView_c_a_queue);


    }

    public void setViewObject() {
        balance = Math.round(userCharge * 10000) / 10000.0;

        totalBalance.setText(String.valueOf(balance));
    }

    public void changeState(boolean state) {
        if (state) {
            position.setTypeface(null, Typeface.BOLD);
            queue.setTypeface(null, Typeface.NORMAL);
        } else if (!state) {
            position.setTypeface(null, Typeface.NORMAL);
            queue.setTypeface(null, Typeface.BOLD);
        } else {

        }
    }


}
