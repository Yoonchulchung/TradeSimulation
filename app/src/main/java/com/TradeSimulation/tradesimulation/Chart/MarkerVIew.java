package com.TradeSimulation.tradesimulation.Chart;


import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

public class MarkerVIew extends MarkerView {

    private TextView priceTextView;
    private TextView dateTextView;

    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public MarkerVIew(Context context, int layoutResource) {
        super(context, layoutResource);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {

        if (e instanceof CandleEntry) {
            CandleEntry ce = (CandleEntry) e;

            priceTextView.setText("Price: " + ce.getHigh());
            dateTextView.setText("");
        } else {
            priceTextView.setText("Price: " + e.getY());
            dateTextView.setText("");
        }
        super.refreshContent(e, highlight);
    }

    @Override
    public void draw(Canvas canvas, float posX, float posY) {
        canvas.translate(200, 100);
        super.draw(canvas, 0, 0);
    }
}
