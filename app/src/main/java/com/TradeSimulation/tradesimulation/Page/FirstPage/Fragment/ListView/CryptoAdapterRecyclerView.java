package com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.Connection.ConnectionAdapter;
import com.TradeSimulation.tradesimulation.Connection.ConnectionMethod;
import com.TradeSimulation.tradesimulation.Currency.ContextCurrency;
import com.TradeSimulation.tradesimulation.JsonParser.JsonCurrentData;
import com.TradeSimulation.tradesimulation.R;

import java.util.ArrayList;

import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonCurrentData;
import static com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.FirstPageThirdFragment.cryptoListHandler;

public class CryptoAdapterRecyclerView extends RecyclerView.Adapter<CryptoAdapterRecyclerView.CryptoHolder> {

    ArrayList<JsonCurrentData> priceData;
    private int currentPosition;
    private Thread thread;
    private ContextCurrency contextCurrency = null;
    private ConnectionAdapter connectionAdapter = null;

    public CryptoAdapterRecyclerView() {
        connectionAdapter = new ConnectionAdapter();
        contextCurrency = ContextCurrency.getInstance();

        this.priceData = jsonCurrentData;
    }

    @NonNull
    @Override
    public CryptoAdapterRecyclerView.CryptoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.a_first_page_c_list, parent, false);
        CryptoAdapterRecyclerView.CryptoHolder holder = new CryptoAdapterRecyclerView.CryptoHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull CryptoAdapterRecyclerView.CryptoHolder holder, int position) {
        holder.textCryptoName.setText(priceData.get(position).getCoinName());
        holder.textCryptoPrice.setText(priceData.get(position).getMarketPrice());
        holder.text24h_vol.setText(priceData.get(position).getUsd_24h_vol());
        holder.textCryptoMarketCap.setText(priceData.get(position).getUsd_market_cap());
    }

    @Override
    public int getItemCount() {
        return priceData.size();
    }


    public class CryptoHolder extends RecyclerView.ViewHolder {

        TextView textCryptoName;
        TextView textCryptoPrice;
        TextView textCryptoMarketCap;
        TextView text24h_vol;

        public CryptoHolder(@NonNull View itemView) {
            super(itemView);

            textCryptoName = itemView.findViewById(R.id.TextCryptoName);
            textCryptoName.setTextSize(14);
            textCryptoName.setTextColor(R.color.white);

            textCryptoPrice = itemView.findViewById(R.id.TextCryptoPrice);
            textCryptoPrice.setTextSize(14);

            text24h_vol = itemView.findViewById(R.id.Text24h_vol);
            text24h_vol.setTextSize(14);

            textCryptoMarketCap = itemView.findViewById(R.id.TextCryptoMarketCap);
            textCryptoMarketCap.setTextSize(14);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Message message = cryptoListHandler.obtainMessage();
                        currentPosition = pos;
                        message.obj = priceData.get(pos).getCoinName();

                        contextCurrency.setCurrency(priceData.get(pos).getCoinName(),
                                priceData.get(pos).getCoinID());
                        connectionAdapter.Connect(ConnectionMethod.HistoryConnection);

                        cryptoListHandler.sendMessage(message);
                        /*
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                        thread.start();

                         */
                    }
                }
            });

        }
    }
}
