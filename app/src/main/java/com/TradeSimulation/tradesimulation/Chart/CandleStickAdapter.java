package com.TradeSimulation.tradesimulation.Chart;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

import com.TradeSimulation.tradesimulation.R;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;

public class CandleStickAdapter {


    static public CandleStickAdapter candleStickAdapter;
    ArrayList<CandleEntry> candleStickData;

    private CandleStickAdapter() {
        if (candleStickData == null) {
            candleStickData = new ArrayList<CandleEntry>();
        } else {

        }
    }

    static public CandleStickAdapter getInstance() {
        if (candleStickAdapter == null) {
            candleStickAdapter = new CandleStickAdapter();

        } else {

        }

        return candleStickAdapter;
    }

    public CandleStickChart InitiateChart(CandleStickChart candleStickChart, Context context) {
        candleStickChart.setHighlightPerDragEnabled(true);
        candleStickChart.setDrawBorders(true);
        candleStickChart.setDragDecelerationEnabled(false); //화면 이동 가속 불가
        candleStickChart.setMinOffset(0);
        candleStickChart.setExtraBottomOffset(6);
        candleStickChart.setBorderColor(context.getColor(R.color.white));
        candleStickChart.setBackgroundColor(context.getColor(R.color.white)); // 그래프 배경 설정

        //Chart Zoom
        candleStickChart.setScaleYEnabled(false); // Y축 변경 불가
        candleStickChart.zoom(2f, 1f, 0.00100f, 0f); //줌 기능
        candleStickChart.moveViewToX(100f); //초기 줌 상태 X축 위치
        candleStickChart.setAutoScaleMinMaxEnabled(true);  //화면 내의 데이터 최대 최소에 따른 줌 기능
        candleStickChart.getViewPortHandler().setMaximumScaleX(5f); //x축 줌 최대 설정
        candleStickChart.setDoubleTapToZoomEnabled(false); //더블 클릭 비활성화
        //lineChart.setVisibleXRangeMinimum(60 * 60 * 24 * 1000 * 5); //라인차트에서 최대로 보여질 X축의 데이터


        //Y axis
        YAxis yAxis = candleStickChart.getAxisLeft();
        YAxis rightAxis = candleStickChart.getAxisRight();
        yAxis.setDrawGridLines(true);
        yAxis.setDrawLabels(true);

        rightAxis.setDrawGridLines(true);

        //X axis
        XAxis xAxis = candleStickChart.getXAxis();

        xAxis.setDrawGridLines(false);// disable x axis grid lines
        xAxis.setDrawLabels(true);

        rightAxis.setTextColor(Color.WHITE);

        xAxis.setGranularity(1f);
        xAxis.setTextSize(8);
        xAxis.setGridLineWidth(8);
        xAxis.setAxisLineWidth(8);
        xAxis.setGranularityEnabled(true);
        xAxis.setAvoidFirstLastClipping(true);
        Legend l = candleStickChart.getLegend();
        l.setEnabled(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //x축 표시에 대한 위치 설정으로 아래쪽에 위치시킨다.
        return candleStickChart;
    }


    // addCandleStickData -> InitatiateData() -> setCandleStickData()
    public void addCandleStickData(long x, Double shadowH, Double shadowL, Double open,
                                   Double close) {
        candleStickData.add(new CandleEntry(x, shadowH.floatValue(), shadowL.floatValue(), open.floatValue(), close.floatValue()));
    }

    public CandleDataSet InitiateData(Context context) {
        CandleDataSet set1 = new CandleDataSet(candleStickData, "DataSet 1");
        set1.setColor(Color.rgb(80, 80, 80));
        set1.setShadowColor(context.getColor(R.color.white));
        set1.setShadowWidth(0.8f);
        set1.setDecreasingColor(context.getColor(R.color.white));
        set1.setDecreasingPaintStyle(Paint.Style.FILL);
        set1.setIncreasingColor(context.getColor(R.color.green));
        set1.setIncreasingPaintStyle(Paint.Style.FILL);
        set1.setNeutralColor(Color.LTGRAY);
        set1.setDrawValues(false);

        return set1;
    }

    public void setCandleStickData(CandleStickChart candleStickChart, CandleDataSet dataSet) {

        // create a data object with the datasets
        CandleData data = new CandleData(dataSet);


        // set data
        candleStickChart.setData(data);
        candleStickChart.invalidate();
    }

}
