package com.TradeSimulation.tradesimulation.Page.SearchPage.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.JsonParser.JsonHistoryData;
import com.TradeSimulation.tradesimulation.R;

import java.util.ArrayList;
import java.util.Collections;

import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonHistoryData;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchHolder> {

    ArrayList<JsonHistoryData> historyData;
    private int currentPosition;
    private Thread thread;

    public SearchAdapter() {

        this.historyData = jsonHistoryData;
        Collections.reverse(historyData);
    }

    @NonNull
    @Override
    public SearchAdapter.SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.b_trading_page_c_list, parent, false);
        SearchAdapter.SearchHolder holder = new SearchAdapter.SearchHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchHolder holder, int position) {
        holder.textDate.setText(String.valueOf(historyData.get(position).getDate()));
        holder.textPrice.setText(String.valueOf(historyData.get(position).getClose()));
    }

    @Override
    public int getItemCount() {
        return historyData.size();
    }


    public class SearchHolder extends RecyclerView.ViewHolder {

        TextView textDate;
        TextView textPrice;

        public SearchHolder(@NonNull View itemView) {
            super(itemView);

            textDate = itemView.findViewById(R.id.Text_Second_History_Date);
            textDate.setTextSize(10);
            textDate.setTextColor(R.color.white);

            textPrice = itemView.findViewById(R.id.Text_Second_History_Price);
            textPrice.setTextSize(10);


        }
    }
}
