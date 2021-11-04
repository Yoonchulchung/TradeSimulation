package com.TradeSimulation.tradesimulation.Page.FourthPage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.Page.FirstPage.FirstPageActivity;
import com.TradeSimulation.tradesimulation.Page.FourthPage.Fragment.SettingPageAnnouncement;
import com.TradeSimulation.tradesimulation.Page.FourthPage.Fragment.SettingPageDonation;
import com.TradeSimulation.tradesimulation.Page.FourthPage.Fragment.SettingPageLanguageSetting;
import com.TradeSimulation.tradesimulation.Page.FourthPage.Fragment.SettingPagePayment;
import com.TradeSimulation.tradesimulation.Page.FourthPage.Fragment.SettingPageUserInfo;
import com.TradeSimulation.tradesimulation.Page.FourthPage.RecentView.SettingAdapter;
import com.TradeSimulation.tradesimulation.Page.FourthPage.RecentView.SettingData;
import com.TradeSimulation.tradesimulation.Page.Login.LoginPage;
import com.TradeSimulation.tradesimulation.Page.TradingPage.TradingActivity;
import com.TradeSimulation.tradesimulation.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class FourthPageActivity extends AppCompatActivity {

    public static Handler settingListHandler = null;
    BottomNavigationView bottomNavigationView;
    ArrayList<SettingData> settingList;
    Intent intent = null;
    TextView signUpOrLogin;
    private long pressedTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.d_fourth_page);
        settingList = new ArrayList<SettingData>();
        signUpOrLogin = findViewById(R.id.Text_Fourth_SignUpOrLogin);

        settingListHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                if (msg.obj != null) {
                    if (msg.obj.equals("UserInfo")) {
                        intent = new Intent(getApplicationContext(), SettingPageUserInfo.class);
                        startActivity(intent);
                    } else if (msg.obj.equals("Language Setting")) {
                        intent = new Intent(getApplicationContext(), SettingPageLanguageSetting.class);
                        startActivity(intent);
                    } else if (msg.obj.equals("Announcement")) {
                        intent = new Intent(getApplicationContext(), SettingPageAnnouncement.class);
                        startActivity(intent);
                    } else if (msg.obj.equals("Donation")) {
                        intent = new Intent(getApplicationContext(), SettingPageDonation.class);
                        startActivity(intent);
                    } else if (msg.obj.equals("Payment")) {
                        intent = new Intent(getApplicationContext(), SettingPagePayment.class);
                        startActivity(intent);
                    } else {
                        System.out.println("WRONG!!!");
                    }
                }
            }
        };
        settingList.add(new SettingData("UserInfo"));
        settingList.add(new SettingData("Language Setting"));
        settingList.add(new SettingData("Announcement"));
        settingList.add(new SettingData("Donation"));
        settingList.add(new SettingData("Payment"));

        RecyclerView recyclerView = findViewById(R.id.SettingRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SettingAdapter settingAdapter = new SettingAdapter(settingList);
        recyclerView.setAdapter(settingAdapter);

        bottomNavigationView = findViewById(R.id.navigation_a);
        bottomNavigationView.setSelectedItemId(R.id.navigation_menu4);

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

        signUpOrLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
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


}
