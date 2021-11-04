package com.TradeSimulation.tradesimulation.Page.LoadingPage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.TradeSimulation.tradesimulation.Connection.ConnectionAdapter;
import com.TradeSimulation.tradesimulation.Connection.ConnectionMethod;
import com.TradeSimulation.tradesimulation.Currency.EnabledCurrencyList;
import com.TradeSimulation.tradesimulation.Language.LanguageAdapter;
import com.TradeSimulation.tradesimulation.Language.LanguageEnum;
import com.TradeSimulation.tradesimulation.Page.FirstPage.FirstPageActivity;
import com.TradeSimulation.tradesimulation.R;
import com.TradeSimulation.tradesimulation.User.UserInfo;

import static com.TradeSimulation.tradesimulation.Language.LanguageEnum.ENG;
import static java.lang.Boolean.FALSE;

public class LoadingPageActivity extends AppCompatActivity {

    private final String SharedPreFile = "com.TradeSimulation.android.SharedPreferences";
    private final int counter = 0;
    private ConnectionAdapter connectionAdapter = null;
    private UserInfo userInfo = null;
    private SharedPreferences sharedPreferences;
    private LanguageAdapter languageAdapter = null;
    private EnabledCurrencyList currencyList = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.__loding_page);
        recoverData();

        connectionAdapter = new ConnectionAdapter();
        languageAdapter = LanguageAdapter.getInstance();
        currencyList = EnabledCurrencyList.getInstance();

        connectionAdapter.Connect(ConnectionMethod.LiveConnection);
        connectionAdapter.Connect(ConnectionMethod.HistoryConnection);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), FirstPageActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    //시작시 데이터 복원
    public void recoverData() {
        userInfo = UserInfo.getInstance();

        sharedPreferences = getSharedPreferences(SharedPreFile, MODE_PRIVATE);
        if (sharedPreferences.getString("CheckSavedState", "FALSE") != "TRUE") {
            userInfo.setUserName(sharedPreferences.getString("UserName", "None"));
            userInfo.setUserCharge(Double.parseDouble
                    (sharedPreferences.getString("UserCharge", "1000")));
            userInfo.setLanguage(LanguageEnum.valueOf(sharedPreferences.getString("UserLanguage", String.valueOf(ENG))));
            userInfo.setUserID(sharedPreferences.getInt("UserID", 0));
            userInfo.setCheckLogin(sharedPreferences.getBoolean("CheckLogin", FALSE));
            userInfo.setFirstActivityPosition(sharedPreferences.getInt("FistPagePosition", 0));
        } else {
            userInfo.setCheckLogin(FALSE);
            userInfo.setUserName("USER");
            userInfo.setUserID(0);
            userInfo.setUserCharge(1000.0);
            userInfo.setLanguage(ENG);
            userInfo.setFirstActivityPosition(0);
        }
    }
}
