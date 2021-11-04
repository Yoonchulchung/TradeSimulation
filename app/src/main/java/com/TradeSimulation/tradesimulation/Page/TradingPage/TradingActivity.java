package com.TradeSimulation.tradesimulation.Page.TradingPage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.TradeSimulation.tradesimulation.Page.FirstPage.FirstPageActivity;
import com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.TradingPageFirstFragment;
import com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.TradingPageSecondFragment;
import com.TradeSimulation.tradesimulation.Page.TradingPage.Fragment.TradingPageThirdFragment;
import com.TradeSimulation.tradesimulation.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class TradingActivity extends AppCompatActivity {
    private static final int NUM = 3;
    private final TextView crypto_24h_vol = null;
    private final ImageView searchImage = null;
    private final TradingPageFirstFragment tradingPageFirstFragment = new TradingPageFirstFragment();
    private ViewPager2 pager = null;
    private TabLayout tabLayout = null;
    private FragmentStateAdapter pagerAdapter = null;
    private ArrayList<String> tabText = null;
    private Bundle bundle = null;
    private TextView cryptoName;
    private TextView price;
    private TradingPageSecondFragment tradingPageSecondFragment = null;
    private ImageView backImage;
    private CurrentState currentState = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_trading_page);

        getViewObject();

        try {
            currentState.setCurrencyName(bundle.getString("CurrentCurrency"));
            cryptoName.setText(currentState.getCurrencyName());

            currentState.setMarketPrice(bundle.getString("CurrentPrice"));
            price.setText(currentState.getMarketPrice());

            crypto_24h_vol.setText(bundle.getString("Current24H_Vol"));

            tradingPageSecondFragment.setArguments(bundle);

        } catch (Exception e) {
            e.printStackTrace();
        }

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FirstPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tabText.add("Order");
        tabText.add("Chart");
        tabText.add("History");

        pagerAdapter = new ScreenSlidePagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        pager.setUserInputEnabled(false); //스와이프 방지
        pager.setPageTransformer(null);
        new TabLayoutMediator(tabLayout, pager, (tab, position) -> tab.setText(tabText.get(position))).attach();

        /*
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchPageActivity.class);
                startActivity(intent);
            }
        });

         */

    }

    @SuppressLint("ResourceAsColor")
    public void getViewObject() {
        bundle = getIntent().getExtras();
        tabText = new ArrayList<>();
        tradingPageSecondFragment = new TradingPageSecondFragment();

        //searchImage = (ImageView)findViewById(R.id.imageview_b);
        pager = findViewById(R.id.viewPager_b);
        tabLayout = findViewById(R.id.tabLayer_b);

        cryptoName = findViewById(R.id.textView_b_currencyName);
        cryptoName.setTextColor(R.color.black);
        price = findViewById(R.id.textView_b_currencyPrice);
        price.setTextSize(30);
        backImage = findViewById(R.id.imageView_b_backImage);

        currentState = CurrentState.getInstance();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                //radingPageFirstFragment.setTotalPrice(1);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0: {
                    return new TradingPageFirstFragment();
                }
                case 1: {
                    return new TradingPageSecondFragment();
                }
                case 2: {
                    return new TradingPageThirdFragment();
                }
            }
            return new TradingPageSecondFragment();
        }

        @Override
        public int getItemCount() {
            return NUM;
        }
    }


}

