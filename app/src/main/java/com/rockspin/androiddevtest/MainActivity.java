package com.rockspin.androiddevtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EVActivityAdapter mAdapter;

    private List<CosmonautData> cosmonautDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mAdapter = new EVActivityAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        MyApplication.getAPIService().getEVList().enqueue(new Callback<List<CosmonautData>>() {
            @Override
            public void onResponse(Call<List<CosmonautData>> call, Response<List<CosmonautData>> response) {
                cosmonautDataList = response.body();
                mAdapter.setCosmonautActivityList(cosmonautDataList);
            }

            @Override
            public void onFailure(Call<List<CosmonautData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error occur while loading data.", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.fab_change_sorting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reverseAdapter();
            }
        });

    }

    private void reverseAdapter() {
        Collections.reverse(cosmonautDataList);

        mAdapter.notifyDataSetChanged();
    }
}
