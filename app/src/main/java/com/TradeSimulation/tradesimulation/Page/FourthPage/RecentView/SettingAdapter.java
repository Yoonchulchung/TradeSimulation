package com.TradeSimulation.tradesimulation.Page.FourthPage.RecentView;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.R;

import java.util.ArrayList;

import static com.TradeSimulation.tradesimulation.Page.FourthPage.FourthPageActivity.settingListHandler;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.SettingHolder> {

    ArrayList<SettingData> settingData = null;

    public SettingAdapter(ArrayList<SettingData> settingData) {
        this.settingData = settingData;
    }

    @NonNull
    @Override
    public SettingAdapter.SettingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.d_listview_layout, parent, false);
        SettingAdapter.SettingHolder holder = new SettingAdapter.SettingHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.SettingHolder holder, int position) {
        holder.textView.setText(settingData.get(position).getMenuName());
    }

    @Override
    public int getItemCount() {
        return settingData.size();
    }


    public class SettingHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public SettingHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView_b_b_list_currencyName);
            textView.setTextSize(14);
            textView.setTextColor(R.color.white);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) ;
                    {
                        Message message = settingListHandler.obtainMessage();
                        message.obj = settingData.get(pos).getMenuName();
                        settingListHandler.sendMessage(message);
                    }
                }
            });
        }
    }
}
