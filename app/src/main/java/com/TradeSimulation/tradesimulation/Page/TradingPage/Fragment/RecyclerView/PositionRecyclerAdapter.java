package com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.JsonParser.JsonCurrentData;
import com.TradeSimulation.tradesimulation.R;
import com.TradeSimulation.tradesimulation.Trade.position.PositionData;

import java.util.ArrayList;

import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonCurrentData;
import static com.TradeSimulation.tradesimulation.Page.ThirdPage.Fragment.ThirdPageFirstFragment.walletRecyclerView;
import static com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.TradingPageFirstFragment.b_b_recyclerView;
import static com.TradeSimulation.tradesimulation.Trade.position.PositionAdapter.positionData;

public class PositionRecyclerAdapter extends RecyclerView.Adapter<PositionRecyclerAdapter.OrderHolder> {

    ArrayList<PositionData> tradeData;
    private int currentPosition;
    private Thread thread;

    private PositionRecyclerAdapter positionRecyclerAdapter = null;

    public PositionRecyclerAdapter() {
        this.tradeData = positionData;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.b_trading_page_b_list, parent, false);
        OrderHolder holder = new OrderHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        holder.textCryptoName.setText(tradeData.get(position).getCurrencyName());
        holder.textEntryPrice.setText(String.valueOf(tradeData.get(position).getEntryPrice()));
        holder.textEntrySize.setText(String.valueOf(tradeData.get(position).getEntrySize()));
        for (JsonCurrentData a : jsonCurrentData) {
            if (tradeData.get(position).getCurrencyName().equals(a.getCoinName())) {
                holder.textMarketPrice.setText(String.valueOf(a.getMarketPrice()));
            }
        }
        holder.textPNL.setText("11");
    }

    @Override
    public int getItemCount() {
        return tradeData.size();
    }


    public class OrderHolder extends RecyclerView.ViewHolder {

        TextView textCryptoName;
        TextView textEntryPrice;
        TextView textPNL;
        TextView textEntrySize;
        TextView textMarketPrice;
        TextView textLiquidationPrice;
        TextView textTradeMethod;
        Button stopButton;

        @SuppressLint("ResourceAsColor")
        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            textCryptoName = itemView.findViewById(R.id.textView_b_b_list_currencyName);
            textCryptoName.setTextSize(10);
            textCryptoName.setTextColor(R.color.white);

            textEntryPrice = itemView.findViewById(R.id.textView_b_b_list_entryPrice);
            textEntryPrice.setTextSize(10);

            textEntrySize = itemView.findViewById(R.id.textView_b_b_list_entrySize);
            textEntrySize.setTextSize(10);

            textPNL = itemView.findViewById(R.id.textView_b_b_list_tradeUnrealizedPNL);
            textPNL.setTextSize(10);

            textMarketPrice = itemView.findViewById(R.id.textView_b_b_list_tradeMarketPrice);
            textMarketPrice.setTextSize(10);

            stopButton = itemView.findViewById(R.id.btn_Second_TradeStateStop);

            stopButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        positionData.remove(pos);
                        if (positionRecyclerAdapter == null) {
                            positionRecyclerAdapter = new PositionRecyclerAdapter();
                        }
                        b_b_recyclerView.setAdapter(positionRecyclerAdapter);
                        if (walletRecyclerView != null) {
                            walletRecyclerView.setAdapter(positionRecyclerAdapter);
                        }

                    }
                }
            });


        }
    }
}