package com.TradeSimulation.tradesimulation.Page.FirstPage;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.TradeSimulation.tradesimulation.Connection.ConnectionAdapter;
import com.TradeSimulation.tradesimulation.Currency.CurrencyAdapter;
import com.TradeSimulation.tradesimulation.Language.LanguageAdapter;
import com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.FirstPageFirstFragment;
import com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.FirstPageSecondFragment;
import com.TradeSimulation.tradesimulation.Page.FirstPage.Fragment.FirstPageThirdFragment;
import com.TradeSimulation.tradesimulation.Page.FourthPage.FourthPageActivity;
import com.TradeSimulation.tradesimulation.Page.SearchPage.SearchPageActivity;
import com.TradeSimulation.tradesimulation.Page.ThirdPage.ThirdActivity;
import com.TradeSimulation.tradesimulation.R;
import com.TradeSimulation.tradesimulation.User.DataBase.Repository;
import com.TradeSimulation.tradesimulation.User.UserInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class FirstPageActivity extends AppCompatActivity {

    private static final int NUM = 3;
    private static final int counter = 0;
    private static final int FirstPageCounter = 0;
    //dataBase
    public static Repository repository;
    private final ArrayList<String> tabText = new ArrayList<>();
    private final CurrencyAdapter currencyAdapter = null;
    private final ConnectionAdapter connectionAdapter = null;
    private ViewPager2 pager;
    private TabLayout tabLayout;
    private TextView searchCrypto;
    private FragmentStateAdapter pagerAdapter;
    private LanguageAdapter languageAdapter = null;
    private UserInfo userInfo = null;
    private int pageCounter = 0;

    private long pressedTime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_first_page);

        if (pageCounter == 0) {
            //getCurrency
            userInfo = UserInfo.getInstance();

            getViewObject();
            bottomNavigation();

            languageAdapter = LanguageAdapter.getInstance();

            repository = new Repository(getApplication());

            tabText.add(languageAdapter.globalChart());
            tabText.add(languageAdapter.recentView());
            tabText.add(languageAdapter.digitalAssetChart());

            pagerAdapter = new ScreenSlidePagerAdapter(this);
            pager.setAdapter(pagerAdapter);
            pager.setCurrentItem(userInfo.getFirstActivityPosition(), false);

            new TabLayoutMediator(tabLayout, pager, (tab, position) -> tab.setText(tabText.get(position)))
                    .attach();

            pageCounter++;
        } else {

        }

        searchCrypto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchPageActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("pause!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Stop!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Destroyed!!");
        /*
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("CheckSavedState", "TRUE");
        editor.putInt("FistPagePosition", pager.getCurrentItem());
        editor.commit();


         */
        ActivityCompat.finishAffinity(this);
    }

    public void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_a);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                                /*
                                Intent intent = new Intent(getApplicationContext(), TradingActivity.class);
                                startActivity(intent);
                                overridePendingTransition(0, 0);
                                break;

                                 */
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

    public void getViewObject() {
        pager = findViewById(R.id.viewPager_a);
        tabLayout = findViewById(R.id.tabLayer_a);
        searchCrypto = findViewById(R.id.textView_a_Search);

    }

    //다른 화면 눌렀을때 키보드 감추기
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
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
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
                    return new FirstPageFirstFragment();
                }

                case 1: {
                    return new FirstPageSecondFragment();
                }
                case 2: {
                    return new FirstPageThirdFragment();
                }

                default:
                    return new FirstPageFirstFragment();
            }
        }

        @Override
        public int getItemCount() {
            return NUM;
        }
    }

}

