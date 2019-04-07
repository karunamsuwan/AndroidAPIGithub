package com.example.applicationgithub;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.applicationgithub.api.Client;
import com.example.applicationgithub.api.Service;
import com.example.applicationgithub.model.datalist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager mLayoutManager;
    public Adapter adapter;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(this);

        Client client = new Client();
        Service api = client.getClient().create(Service.class);
        Call<List<datalist>> call = api.getActor();

        call.enqueue(new Callback<List<datalist>>() {
            @Override
            public void onResponse(Call<List<datalist>> call, Response<List<datalist>> response) {

                List<datalist> repoList = new ArrayList<datalist>();
                repoList = response.body();

                adapter = new Adapter(getApplicationContext(), repoList);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.scrollToPosition(0);
            }

            @Override
            public void onFailure(Call<List<datalist>> call, Throwable t) {
                Log.d("onFailure",t.getMessage());
                Toast.makeText(MainActivity.this,"error download Github", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
