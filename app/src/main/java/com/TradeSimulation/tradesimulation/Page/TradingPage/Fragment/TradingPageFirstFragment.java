package com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.Calculate.CalculateMarket;
import com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.ListView.CryptoAdapterRecyclerView;
import com.TradeSimulation.tradesimulation.Page.TradingPage.CurrentState;
import com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.RecyclerView.PositionRecyclerAdapter;
import com.TradeSimulation.tradesimulation.R;
import com.TradeSimulation.tradesimulation.Trade.TradeAdapter;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod;
import com.TradeSimulation.tradesimulation.Trade.TradeMethod1;
import com.TradeSimulation.tradesimulation.User.UserInfo;

public class TradingPageFirstFragment extends Fragment {

    public static RecyclerView b_b_recyclerView = null;
    static CryptoAdapterRecyclerView orderAdapter = null;
    private final int leverage = 1;
    private final boolean isolateOrMargin = true;
    private TextView userCharge;
    private EditText amount;
    private EditText price;
    private TextView tradeText;
    private SeekBar seekbar;
    private TextView categoryBuy;
    private TextView categorySell;
    private TextView priceAdder;
    private TextView priceSubtractor;
    private TextView amountAdder;
    private TextView amountSubtractor;
    private TextView textAmount25;
    private TextView textAmount50;
    private TextView textAmount75;
    private TextView textAmount100;
    private TextView cost;
    private TextView unrealizedPnL;
    private TextView marginRatio;
    private TextView categoryPosition;
    private TextView categoryQueue;
    private View imageAmount25;
    private View imageAmount50;
    private View imageAmount75;
    private View imageAmount100;
    private TextView textLeverage;
    private UserInfo userInfo;
    //static PositionRecyclerAdapter orderAdapter = null;
    private TradeAdapter tradeAdapter;
    private CurrentState currentState = null;
    private CalculateMarket calculateMarket = null;
    private double entrySize = 0.0;
    private double totalPrice;
    //tradeMethod = 0 equals Limit Order
    //tradeMethod = 1 equals Market Order
    private byte tradeMethod;
    //tradeCategory = true equals Buy
    //tradeCategory = false equals Sell
    private boolean tradeCategory = true;
    //tradeRecyclerView = true equals position
    //tradeRecyclerView = false equals queue
    private boolean tradeRecyclerView = true;
    //isolateOrMargin = true equals isolate
    //isolateOrMargin = false equals margin
    private ViewGroup rootView = null;

    private PositionRecyclerAdapter positionRecyclerAdapter = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.b_trading_page_b_fragment_order, container, false);

        getViewObject();

        b_b_recyclerView = rootView.findViewById(R.id.recyclerView_b_b);
        b_b_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (positionRecyclerAdapter == null) {
            positionRecyclerAdapter = new PositionRecyclerAdapter();
        }

        b_b_recyclerView.setAdapter(positionRecyclerAdapter);

        changeCategory(tradeCategory);
        changeRecyclerView(tradeRecyclerView);

        categoryBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeCategory(tradeCategory = true);
            }
        });

        categorySell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeCategory(tradeCategory = false);
            }
        });

        priceAdder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePrice(true);

                changeColor((byte) 0);
            }
        });

        priceSubtractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePrice(false);

                changeColor((byte) 0);
            }
        });

        amountAdder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmount(true, 1);

                changeColor((byte) 0);
            }
        });

        amountSubtractor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmount(false, 1);

                changeColor((byte) 0);
            }
        });

        textAmount25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmountInPercent((byte) 11001, 1);
            }
        });

        textAmount50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmountInPercent((byte) 110010, 1);
            }
        });

        textAmount75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmountInPercent((byte) 1001011, 1);
            }
        });

        textAmount100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeAmountInPercent((byte) 1100100, 1);
            }
        });

        //trade 시작!
        tradeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!amount.getText().toString().equals("")) {
                    initiateTrade( /*Double.parseDouble(price.getText().toString())*/ Double.parseDouble(currentState.getMarketPrice()),
                            Double.parseDouble(amount.getText().toString()));

                    userCharge.setText(String.valueOf(
                            Math.round(userInfo.getUserCharge() * 100.0) / 100.0));
                    amount.setText("");

                    changeColor((byte) 0);
                }
            }
        });

        categoryPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeRecyclerView(tradeRecyclerView = true);
            }
        });

        categoryQueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeRecyclerView(tradeRecyclerView = false);
            }
        });

        if (seekbar != null) {
            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    // Write code to perform some action when progress is changed.
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // Write code to perform some action when touch is started.
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // Write code to perform some action when touch is stopped.
                }
            });
        }

        return rootView;
    }

    public void getViewObject() {
        userCharge = rootView.findViewById(R.id.textView_b_b_available);
        amount = rootView.findViewById(R.id.EditText_b_b_amount);
        price = rootView.findViewById(R.id.EditText_b_b_price);
        seekbar = rootView.findViewById(R.id.SeekBar_b_b);
        categoryBuy = rootView.findViewById(R.id.textView_b_b_buy);
        categorySell = rootView.findViewById(R.id.textView_b_b_sell);
        priceAdder = rootView.findViewById(R.id.textView_b_b_pricePositive);
        priceSubtractor = rootView.findViewById(R.id.textView_b_b_priceNegative);
        amountAdder = rootView.findViewById(R.id.textView_b_b_amountPositive);
        amountSubtractor = rootView.findViewById(R.id.textView_b_b_amountNegative);
        textAmount25 = rootView.findViewById(R.id.textView_b_b_25);
        textAmount50 = rootView.findViewById(R.id.textView_b_b_50);
        textAmount75 = rootView.findViewById(R.id.textView_b_b_75);
        textAmount100 = rootView.findViewById(R.id.textView_b_b_100);
        cost = rootView.findViewById(R.id.textView_b_b_cost);
        unrealizedPnL = rootView.findViewById(R.id.textView_b_b_unrealizedPNL);
        marginRatio = rootView.findViewById(R.id.textView_b_b_marginRatio);
        categoryPosition = rootView.findViewById(R.id.textView_b_b_position);
        categoryQueue = rootView.findViewById(R.id.textView_b_b_queue);
        tradeText = rootView.findViewById(R.id.textView_b_b_longOrShort);
        imageAmount25 = rootView.findViewById(R.id.view_b_b_25);
        imageAmount50 = rootView.findViewById(R.id.view_b_b_50);
        imageAmount75 = rootView.findViewById(R.id.view_b_b_75);
        imageAmount100 = rootView.findViewById(R.id.view_b_b_100);
        textLeverage = rootView.findViewById(R.id.textView_b_b_Leverage);

        userInfo = UserInfo.getInstance();
        tradeAdapter = TradeAdapter.getInstance();
        currentState = CurrentState.getInstance();

        userCharge.setText(String.valueOf(Math.round(userInfo.getUserCharge() * 100) / 100.0));
        textLeverage.setText("X" + leverage);
    }

    @SuppressLint("SetTextI18n")
    public void changeCategory(boolean category) {
        if (category) {
            categorySell.setTypeface(null, Typeface.NORMAL);
            categoryBuy.setTypeface(null, Typeface.BOLD);

            tradeText.setText("Buy / Long");
        } else if (!category) {
            categoryBuy.setTypeface(null, Typeface.NORMAL);
            categorySell.setTypeface(null, Typeface.BOLD);

            tradeText.setText("Sell / Short");
        }
    }

    public void changePrice(boolean option) {
        if (price.getText().toString().matches("")) {
            if (option) {
                price.setText("1.0");
            }
        } else {
            if (option) {
                if (Double.parseDouble(price.getText().toString()) != 0) {
                    price.setText(String.valueOf(Double.parseDouble(price.getText().toString()) + 1));
                } else {
                    price.setText("1.0");
                }

            } else if (!option) {
                if (Double.parseDouble(price.getText().toString()) != 0) {
                    price.setText(String.valueOf(Double.parseDouble(price.getText().toString()) - 1));

                } else {

                }
            }
        }
    }

    public void changeAmount(boolean option, int leverage) {
        if (amount.getText().toString().matches("")) {
            if (option) {
                amount.setText("1.0");
                entrySize = 1.0;
                setTotalPrice(leverage);
            }
        } else {
            if (option) {
                if (Double.parseDouble(amount.getText().toString()) != 0) {
                    entrySize = entrySize + 1;
                    entrySize = Math.round(entrySize * 100.0) / 100.0;

                    amount.setText(String.valueOf(entrySize));
                    setTotalPrice(leverage);
                } else {
                    amount.setText("1.0");
                }
            } else if (!option) {
                if (Double.parseDouble(amount.getText().toString()) != 0) {
                    entrySize = entrySize - 1;
                    entrySize = Math.round(entrySize * 100.0) / 100.0;

                    amount.setText(String.valueOf(entrySize));
                    setTotalPrice(leverage);
                } else {

                }
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    public void changeAmountInPercent(byte percent, int leverage) {
        calculateMarket = new CalculateMarket();
        //25
        if (percent == (byte) 11001) {
            changeColor(percent);

            //market 기준
            setAmount(percent, leverage);
            setTotalPrice(leverage);
        }
        //50
        else if (percent == (byte) 110010) {
            changeColor(percent);

            setAmount(percent, leverage);
            setTotalPrice(leverage);
        }
        //75
        else if (percent == (byte) 1001011) {
            changeColor(percent);

            setAmount(percent, leverage);

            setTotalPrice(leverage);
        }
        //100
        else if (percent == (byte) 1100100) {
            changeColor(percent);

            setAmount(percent, leverage);
            setTotalPrice(leverage);
        } else {

        }
    }

    public void changeColor(byte percent) {
        //25
        if (percent == (byte) 11001) {
            imageAmount25.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount50.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
            imageAmount75.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
            imageAmount100.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
        }
        //50
        else if (percent == (byte) 110010) {
            imageAmount25.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount50.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount75.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
            imageAmount100.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
        }
        //75
        else if (percent == (byte) 1001011) {
            imageAmount25.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount50.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount75.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount100.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
        }

        //100
        else if (percent == (byte) 1100100) {
            imageAmount25.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount50.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount75.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
            imageAmount100.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioEnable));
        } else {
            imageAmount25.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
            imageAmount50.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
            imageAmount75.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
            imageAmount75.setBackgroundColor(
                    rootView.getContext().getResources().getColor(R.color.TradeAmountRatioDisable));
        }
    }

    public void initiateTrade(double entryPrice, double entrySize) {
        CurrentState currentState = CurrentState.getInstance();
        if (tradeCategory) {
            if (isolateOrMargin) {
                tradeAdapter.initiateTrade(currentState.getCurrencyName(), entryPrice, entrySize,
                        TradeMethod.LONG, TradeMethod1.Isolate);
            } else if (!isolateOrMargin) {
                tradeAdapter.initiateTrade(currentState.getCurrencyName(), entryPrice, entrySize,
                        TradeMethod.LONG, TradeMethod1.Cross);
            } else {

            }
        } else if (!tradeCategory) {
            if (isolateOrMargin) {
                tradeAdapter.initiateTrade(currentState.getCurrencyName(), entryPrice, entrySize,
                        TradeMethod.SHORT, TradeMethod1.Isolate);
            } else if (!isolateOrMargin) {
                tradeAdapter.initiateTrade(currentState.getCurrencyName(), entryPrice, entrySize,
                        TradeMethod.SHORT, TradeMethod1.Cross);
            }
        } else {

        }
    }

    public void changeRecyclerView(boolean tradeRecyclerView) {
        if (tradeRecyclerView) {
            categoryPosition.setTypeface(null, Typeface.BOLD);
            categoryQueue.setTypeface(null, Typeface.NORMAL);
        } else if (!tradeRecyclerView) {
            categoryPosition.setTypeface(null, Typeface.NORMAL);
            categoryQueue.setTypeface(null, Typeface.BOLD);
        } else {

        }
    }

    public void setTotalPrice(int leverage) {
        try {
            totalPrice = calculateMarket.getCost(Double.parseDouble(
                    currentState.getMarketPrice()),
                    entrySize / leverage);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(totalPrice);
        }

        totalPrice = Math.round(totalPrice * 100) / 100.0;

        cost.setText(String.valueOf(totalPrice));
    }

    public void setAmount(byte percent, int leverage) {
        entrySize = calculateMarket.getMarketSize(percent, Double.parseDouble(
                currentState.getMarketPrice()), leverage);
        entrySize = Math.round(entrySize * 100) / 100.0;

        amount.setText(String.valueOf(entrySize));
    }


}
