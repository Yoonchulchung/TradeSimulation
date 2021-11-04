package com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.TradeSimulation.tradesimulation.Chart.CandleStickAdapter;
import com.TradeSimulation.tradesimulation.JsonParser.JsonHistoryData;
import com.TradeSimulation.tradesimulation.R;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;

import static com.TradeSimulation.tradesimulation.JsonParser.JsonParser.jsonHistoryData;


public class TradingPageSecondFragment extends Fragment {

    private final CandleStickAdapter candleStickAdapter = null;
    private final Bundle bundle = null;
    private final ArrayList<CandleEntry> candleStickData = new ArrayList<CandleEntry>();
    CandleDataSet candleDataSet;
    private ViewGroup rootView = null;
    private CandleStickChart candleStickChart;
    private ArrayList<JsonHistoryData> arrayList;

    private int counter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.b_trading_page_a_fragment_chart, container, false);

        //MarkerView markerView = new com.example.test.Chart.MarkerView(this, R.layout.custom_marker_view);

        candleStickChart = rootView.findViewById(R.id.CandleStickChart);
        //candleStickAdapter = CandleStickAdapter.getInstance();
        //candleStickChart = candleStickAdapter.InitiateChart(candleStickChart, getContext());

        for (JsonHistoryData a : jsonHistoryData) {
            candleStickData.add(new CandleEntry(counter, a.getHigh(), a.getLow(), a.getOpen(), a.getClose()));
            counter = counter + 1;
        }

        //-------------------------
        CandleStickChart candleStickChart;
        candleStickChart = rootView.findViewById(R.id.CandleStickChart);
        candleStickChart.setHighlightPerDragEnabled(true);
        candleStickChart.setDrawBorders(true);
        candleStickChart.setDragDecelerationEnabled(false); //화면 이동 가속 불가
        candleStickChart.setMinOffset(0);
        candleStickChart.setExtraBottomOffset(6);
        candleStickChart.setBorderColor(getResources().getColor(R.color.white));
        candleStickChart.setBackgroundColor(R.color.white); // 그래프 배경 설정

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

        //--------------------------


        //candleDataSet = candleStickAdapter.InitiateData(getContext());

        //---------------------------
        CandleDataSet set1 = new CandleDataSet(candleStickData, "DataSet 1");
        set1.setColor(Color.rgb(80, 80, 80));
        set1.setShadowColor(getResources().getColor(R.color.gray));
        set1.setShadowWidth(0.8f);
        set1.setDecreasingColor(getResources().getColor(R.color.Red));
        set1.setDecreasingPaintStyle(Paint.Style.FILL);
        set1.setIncreasingColor(getResources().getColor(R.color.green));
        set1.setIncreasingPaintStyle(Paint.Style.FILL);
        set1.setNeutralColor(Color.LTGRAY);
        set1.setDrawValues(false);
        //-----------------

        // candleStickAdapter.setCandleStickData(candleStickChart, candleDataSet);

        //--------------------
        // create a data object with the datasets
        CandleData data = new CandleData(set1);


        // set data
        candleStickChart.setData(data);
        candleStickChart.invalidate();
        //---------------

        //bundle에서 데이터 받아서 해당 Context or 이전 첫번쨰 세번째 프레그먼트에서 선택한
        //코인 이름에 따라 차트 데이터 받아서 차트 주입시켜주기.

            /*

        //
        candleStickAdapter.addCandleStickData(0, 225, 219, 224, 221);
        //data
        yValsCandleStick.add(new CandleEntry());
        yValsCandleStick.add(new CandleEntry(1, 228, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(2, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(3, 222, 217, 222, 217));
        yValsCandleStick.add(new CandleEntry(4, 225, 219, 224, 221));
        yValsCandleStick.add(new CandleEntry(5, 228, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(6, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(7, 222, 217, 222, 217));
        yValsCandleStick.add(new CandleEntry(8, 225, 219, 224, 221));
        yValsCandleStick.add(new CandleEntry(9, 228, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(10, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(11, 222, 217, 222, 217));
        yValsCandleStick.add(new CandleEntry(12, 225, 219, 224, 221));
        yValsCandleStick.add(new CandleEntry(13, 228, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(14, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(15, 222, 217, 222, 217));
        yValsCandleStick.add(new CandleEntry(16, 300, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(17, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(18, 222, 217, 222, 217));
        yValsCandleStick.add(new CandleEntry(19, 225, 219, 224, 221));
        yValsCandleStick.add(new CandleEntry(20, 250, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(21, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(22, 690, 217, 600, 217));
        yValsCandleStick.add(new CandleEntry(23, 225, 219, 224, 221));
        yValsCandleStick.add(new CandleEntry(24, 228, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(25, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(26, 222, 217, 222, 217));
        yValsCandleStick.add(new CandleEntry(27, 225, 219, 224, 221));
        yValsCandleStick.add(new CandleEntry(28, 228, 222, 223, 226));
        yValsCandleStick.add(new CandleEntry(29, 226, 222, 225, 223));
        yValsCandleStick.add(new CandleEntry(30, 222, 217, 222, 217));


        CandleDataSet set1 = new CandleDataSet(yValsCandleStick, "DataSet 1");
        set1.setColor(Color.rgb(80, 80, 80));
        set1.setShadowColor(getResources().getColor(R.color.white));
        set1.setShadowWidth(0.8f);
        set1.setDecreasingColor(getResources().getColor(R.color.white));
        set1.setDecreasingPaintStyle(Paint.Style.FILL);
        set1.setIncreasingColor(getResources().getColor(R.color.green));
        set1.setIncreasingPaintStyle(Paint.Style.FILL);
        set1.setNeutralColor(Color.LTGRAY);
        set1.setDrawValues(false);


// create a data object with the datasets
        CandleData data = new CandleData(set1);


// set data
        candleStickChart.setData(data);
        candleStickChart.invalidate();
        //markerView.setChartView(candleStickChart);
        //candleStickChart.setMarker(markerView);

         */

        return rootView;


    }

}

    /*
    public void setCandleStick(float x, float shadowH, float shadowL, float open, float close)
    {
        this.candleStickInitiator = candleStickInitiator;

        //캔들스틱 차트 생성
        candleStickInitiator.Initiator(x, shadowH, shadowL, open, close);

        //캔들스틱 설정
        setCandleStickChart();


        changeZoom(true, 1f,1f, 0f, 0f, true, 5f);
        setYAxis();
        setXAxis();
    }

    //캔들스틱 설정
    public void setCandleStickChart()
    {
        candleStickChart = (CandleStickChart)rootView.findViewById(R.id.CandleStickChart);
        candleStickChart.setHighlightPerDragEnabled(true);
        candleStickChart.setDrawBorders(true);
        candleStickChart.setDragDecelerationEnabled(false);
        candleStickChart.setMinOffset(0);
        candleStickChart.setExtraBottomOffset(0);
        candleStickChart.setBorderColor(getResources().getColor(R.color.black));
        candleStickChart.setBackgroundColor(R.color.white);
    }

    //캔들스틱 확대 기능
    public void changeZoom(boolean YAxis, float scaleX, float scaleY, float X, float Y, boolean MaxMinScale, float xAxis)
    {
        candleStickChart.setScaleYEnabled(YAxis); // Y축 변경 불가
        candleStickChart.zoom(scaleX, scaleY, X, Y); //줌 기능
        candleStickChart.setAutoScaleMinMaxEnabled(MaxMinScale);  //화면 내의 데이터 최대 최소에 따른 줌 기능
        candleStickChart.getViewPortHandler().setMaximumScaleX(xAxis); //x축 줌 최대 설정
        candleStickChart.moveViewToX(100f); //초기 줌 상태 X축 위치
        candleStickChart.setDoubleTapToZoomEnabled(false); //더블 클릭 비활성화
    }

    //캔들스틱 Y축 설정
    public void setYAxis()
    {
        YAxis yAxis = candleStickChart.getAxisLeft();
        YAxis rightAxis = candleStickChart.getAxisRight();
        yAxis.setDrawGridLines(true);
        yAxis.setDrawLabels(true);

        rightAxis.setDrawGridLines(false);
        rightAxis.setTextColor(Color.WHITE);

    }

    public void setXAxis()
    {
        XAxis xAxis = candleStickChart.getXAxis();

        xAxis.setDrawGridLines(false);// disable x axis grid lines
        xAxis.setDrawLabels(true);

        xAxis.setGranularity(1f);
        xAxis.setTextSize(8);
        xAxis.setGridLineWidth(8);
        xAxis.setAxisLineWidth(8);
        xAxis.setGranularityEnabled(true);
        xAxis.setAvoidFirstLastClipping(true);
        Legend l = candleStickChart.getLegend();
        l.setEnabled(false);
    }

    public void setCandleDataSetSetting(ArrayList<CandleEntry> arrPrice, String label)
    {
        candleDataSet = new CandleDataSet(arrPrice, label);
        candleDataSet.setColor(Color.rgb(80, 80, 80));
        candleDataSet.setShadowColor(getResources().getColor(R.color.white));
        candleDataSet.setShadowWidth(0.8f);
        candleDataSet.setDecreasingColor(getResources().getColor(R.color.red));  //하락
        candleDataSet.setDecreasingPaintStyle(Paint.Style.FILL);
        candleDataSet.setIncreasingColor(getResources().getColor(R.color.green));  //상승
        candleDataSet.setIncreasingPaintStyle(Paint.Style.FILL);
        candleDataSet.setNeutralColor(Color.LTGRAY);
        candleDataSet.setDrawValues(false);
    }

    //setCandleDataSetSetting 이후 사용
    public void initiateDataChart(Context context, int layout)
    {
        CandleData data = new CandleData(candleDataSet);
        MarkerView markerView = new MarkerView(context, layout);

        candleStickChart.invalidate();
        markerView.setChartView(candleStickChart);
        candleStickChart.setMarker(markerView);
    }

     */

