package com.TradeSimulation.tradesimulation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import javax.websocket.OnMessage;

import java.net.URI;

public class test1 extends AppCompatActivity {
    static String WebMessage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firtst_Page);
    }

    public static void a() throws Exception
    {
        WebSocketClient webSocketClient = new WebSocketClient(new URI("wss://stream.binance.com:9443/ws/btcusdtCandle@depth"))
        {

            public void onOpen(ServerHandshake handshakedata) {
                System.out.println("Connected!");
            }

            @OnMessage
            public void onMessage(String message)
            {
                WebMessage = message;
            }

            public void onClose(int code, String reason, boolean remote) {
                System.out.println("closed!");
            }

            public void onError(Exception ex) {
                ex.printStackTrace();
            }
        };
        webSocketClient.connect();
    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
            a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Button button = findViewById(R.id.button1);
        TextView text = findViewById(R.id.textView1);

        button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                            System.out.println("clicked!");
                            text.setText(WebMessage);
                    }
                }

        );

    }
}
