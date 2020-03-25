package com.trustedoffer.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.trustedoffer.retrofit.network.MostWicketServiceAPI;
import com.trustedoffer.retrofit.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private MostWicketServiceAPI pojoInterface;
    public List<MostWicket> wicketdata = new ArrayList();
    private BestBowlingAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvbestbowlingid);
        //Initializing Interface
        pojoInterface = RetrofitClient.getRetrofitClient().create(MostWicketServiceAPI.class);
        pojoInterface.getData().enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                ModelClass dataList = response.body();
                wicketdata = dataList.getMostWickets();
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
                adapter = new BestBowlingAdapter(getApplicationContext(), wicketdata);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {

            }
        });
    }
}