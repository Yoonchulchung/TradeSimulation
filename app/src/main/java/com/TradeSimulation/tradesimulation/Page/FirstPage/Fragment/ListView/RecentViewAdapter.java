package com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.R;

import java.util.ArrayList;

public class RecentViewAdapter extends RecyclerView.Adapter<RecentViewAdapter.RecentViewHolder> {

    ArrayList<RecentViewData> recentViewData;

    public RecentViewAdapter(ArrayList<RecentViewData> recentViewData) {
        this.recentViewData = recentViewData;
    }

    @NonNull
    @Override
    public RecentViewAdapter.RecentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.a_first_page_c_list, parent, false);
        RecentViewAdapter.RecentViewHolder holder = new RecentViewAdapter.RecentViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentViewAdapter.RecentViewHolder holder, int position) {
        holder.textRecentViewPrice.setText(recentViewData.get(position).getCryptoName());
        holder.textRecentViewPrice.setText(recentViewData.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return recentViewData.size();
    }


    public class RecentViewHolder extends RecyclerView.ViewHolder {

        TextView textRecentViewName;
        TextView textRecentViewPrice;

        public RecentViewHolder(@NonNull View itemView) {
            super(itemView);

            textRecentViewName = itemView.findViewById(R.id.textView_b_b_list_currencyName);
            textRecentViewName.setTextSize(14);
            textRecentViewName.setTextColor(R.color.white);

            textRecentViewPrice = itemView.findViewById(R.id.TextCryptoPrice);
            textRecentViewPrice.setTextSize(14);

        }
    }
}
