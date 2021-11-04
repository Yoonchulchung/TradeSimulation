package com.TradeSimulation.tradesimulation.Page.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.TradeSimulation.tradesimulation.R;

public class LoginPage extends AppCompatActivity {

    TextView signUp;
    TextView resetPassword;
    TextView findID;
    Button btnLogin;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.f_login_page);
        signUp = findViewById(R.id.TextSignUp);
        btnLogin = findViewById(R.id.btn_Login);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpPage.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
