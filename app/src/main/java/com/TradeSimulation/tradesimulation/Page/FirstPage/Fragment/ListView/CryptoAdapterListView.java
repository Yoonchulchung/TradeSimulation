/*
package com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.TradeSimulation.tradesimulation.JsonParser.JsonCurrentData;

import java.util.ArrayList;

import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonCurrentData;

public class CryptoAdapterListView extends BaseAdapter {

    ArrayList<JsonCurrentData> priceData;

    public CryptoAdapterListView()
    {
        this.priceData = jsonCurrentData;
    }
    @Override
    public int getCount() {
        return priceData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View cornerView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        if (cornerView == null)
        {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        return null;
    }
}


 */