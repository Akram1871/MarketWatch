package com.example.marketwatchsystem.PL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.marketwatchsystem.AL.ActionAL;
import com.example.marketwatchsystem.AL.ProductInfo;
import com.example.marketwatchsystem.R;

import java.util.ArrayList;

public class ActionPL extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<ProductInfo> products;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        loadMyRecyclerView();

        products = new ActionAL().takeAction(this);
        adapter = new MyAdapter(products,this);
        recyclerView.setAdapter(adapter);
    }

    private void loadMyRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}