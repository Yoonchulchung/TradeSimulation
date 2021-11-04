package com.TradeSimulation.tradesimulation.Page.FourthPage.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.TradeSimulation.tradesimulation.R;

public class SettingPageLanguageSetting extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.d_language_setting);

        System.out.println("Languatge");
    }
}
