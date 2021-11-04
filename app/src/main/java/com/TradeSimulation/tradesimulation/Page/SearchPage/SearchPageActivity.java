package com.TradeSimulation.tradesimulation.Page.SearchPage;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.TradeSimulation.tradesimulation.Page.SearchPage.RecyclerView.SearchAdapter;
import com.TradeSimulation.tradesimulation.R;

public class SearchPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private SearchAdapter searchAdapter = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.e_search_page);

        recyclerView = findViewById(R.id.Recycler_Search_RecentView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        System.out.println("!!!");
        if (searchAdapter == null) {
            searchAdapter = new SearchAdapter();
        } else {

        }
        recyclerView.setAdapter(searchAdapter);

        /*
        //change state after EditText has been changed
        searchCrypto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                pager.setCurrentItem(2);

                for(EnableData a : currencyList.getArrayList())
                {
                    StringBuilder sb = null;
                    for(int i = 0; i < a.getCryptoName().length(); i++)
                    {
                        sb.append(a.getCryptoName().charAt(i));
                        if(sb.equals(editable.toString()))
                        {
                            System.out.println(a.getCryptoName());
                        }
                    }
                    sb.setLength(0);
                }


            }
        });



         */
    }

}
