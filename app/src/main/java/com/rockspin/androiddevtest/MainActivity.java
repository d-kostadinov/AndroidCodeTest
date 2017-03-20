package com.rockspin.androiddevtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EVActivityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new EVActivityAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        MyApplication.getAPIService().getEVList().enqueue(new Callback<List<CosmonautActivity>>() {
            @Override
            public void onResponse(Call<List<CosmonautActivity>> call, Response<List<CosmonautActivity>> response) {
                final List<CosmonautActivity> cosmonautActivityList = response.body();
                mAdapter.setCosmonautActivityList(cosmonautActivityList);
            }

            @Override
            public void onFailure(Call<List<CosmonautActivity>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error occur while loading data.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
