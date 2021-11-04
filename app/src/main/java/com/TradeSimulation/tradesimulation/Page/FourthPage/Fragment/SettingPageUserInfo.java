package com.TradeSimulation.tradesimulation.Page.FourthPage.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.TradeSimulation.tradesimulation.R;

public class SettingPageUserInfo extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.d_user_info);
        System.out.println("UserInfo");
    }
}
