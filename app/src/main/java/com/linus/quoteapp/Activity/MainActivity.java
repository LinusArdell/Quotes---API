package com.linus.quoteapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.linus.quoteapp.API.APIRequestData;
import com.linus.quoteapp.API.RetrofitServer;
import com.linus.quoteapp.Model.QuotesModel;
import com.linus.quoteapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvQuotes;
    private ProgressBar pbQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvQuotes = findViewById(R.id.rv_quotes);
        pbQuotes = findViewById(R.id.pb_quote);

        rvQuotes.setLayoutManager(new LinearLayoutManager(this));
        retrieveQuote();
    }

    private void retrieveQuote(){
        pbQuotes.setVisibility(View.VISIBLE);

        APIRequestData ARD = RetrofitServer.connectRetrofit().create(APIRequestData.class);
        Call<List<QuotesModel>> retrieveProcess = ARD.requestData();

        retrieveProcess.enqueue(new Callback<List<QuotesModel>>() {
            @Override
            public void onResponse(Call<List<QuotesModel>> call, Response<List<QuotesModel>> response) {
                
            }

            @Override
            public void onFailure(Call<List<QuotesModel>> call, Throwable t) {

            }
        });
    }
}