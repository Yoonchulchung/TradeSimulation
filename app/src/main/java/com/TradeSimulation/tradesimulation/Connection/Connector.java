package com.TradeSimulation.tradesimulation.Connection;

import androidx.annotation.NonNull;

import com.TradeSimulation.tradesimulation.JsonParser.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class Connector extends Thread {


    private final Runnable runnable = null;
    private StringBuilder stringBuilder = null;
    private JsonParser jsonParser = null;
    private ConnectionMethod connectionMethod = null;
    private String jsonData = null;
    private String uri = null;

    public Connector(@NonNull ConnectionMethod connectionMethod, @NonNull String uri) {
        stringBuilder = new StringBuilder();
        jsonParser = new JsonParser(connectionMethod);
        this.connectionMethod = connectionMethod;
        this.uri = uri;
    }


    @Override
    public void run() {
        super.run();

        if (uri != null) {
            try {
                URL u = new URL(uri);
                URLConnection uc = u.openConnection();

                try (InputStream raw = uc.getInputStream()) {
                    Reader reader = new InputStreamReader(uc.getInputStream());
                    reader = new BufferedReader(reader, 1024);
                    int c;

                    while ((c = reader.read()) != -1) {
                        stringBuilder.append((char) c);
                    }

                    jsonData = new String(stringBuilder);
                    jsonParser.StartParsing(jsonData);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

        }
    }
}
