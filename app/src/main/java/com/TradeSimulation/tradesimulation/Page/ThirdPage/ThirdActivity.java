package com.TradeSimulation.tradesimulation.Page.ThirdPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.TradeSimulation.tradesimulation.Page.FirstPage.FirstPageActivity;
import com.TradeSimulation.tradesimulation.Page.FourthPage.FourthPageActivity;
import com.TradeSimulation.tradesimulation.Page.ThirdPage.Fragment.ThirdPageFirstFragment;
import com.TradeSimulation.tradesimulation.Page.ThirdPage.Fragment.ThirdPageSecondFragment;
import com.TradeSimulation.tradesimulation.Page.TradingPage.TradingActivity;
import com.TradeSimulation.tradesimulation.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private static final int NUM = 2;
    private final ArrayList<String> tabText = new ArrayList<>();
    private ViewPager2 pager;
    private TabLayout tabLayout;
    private FragmentStateAdapter pagerAdapter;

    private long pressedTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_history_page);

        pager = findViewById(R.id.viewPager_c);
        tabLayout = findViewById(R.id.tabLayer_c);

        bottomNavigation();

        tabText.add("OverView");
        tabText.add("History");

        pagerAdapter = new ThirdActivity.ScreenSlidePagerAdapter(this);
        pager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, pager, (tab, position) -> tab.setText(tabText.get(position)))
                .attach();
    }


    public void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_c);
        bottomNavigationView.setSelectedItemId(R.id.navigation_menu3);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch ((item.getItemId())) {
                    case R.id.navigation_menu1: {
                        Intent intent = new Intent(getApplicationContext(), FirstPageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        break;
                    }
                    case R.id.navigation_menu2: {
                        Intent intent = new Intent(getApplicationContext(), TradingActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        break;
                    }
                    case R.id.navigation_menu3: {
                        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        break;
                    }
                    case R.id.navigation_menu4: {
                        Intent intent = new Intent(getApplicationContext(), FourthPageActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        break;
                    }
                }
                finish();
                return true;
            }
        });
    }

    //Back Again
    @Override
    public void onBackPressed() {

        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back agian to exit", Toast.LENGTH_SHORT).show();
        }

        pressedTime = System.currentTimeMillis();
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0: {
                    return new ThirdPageFirstFragment();
                }

                case 1: {
                    return new ThirdPageSecondFragment();
                }
                default:
                    return new ThirdPageFirstFragment();
            }
        }

        @Override
        public int getItemCount() {
            return NUM;
        }
    }


}

