package com.example.marketwatchsystem.PL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marketwatchsystem.AL.StatisticsAL;
import com.example.marketwatchsystem.AL.HandleZoneAL;
import com.example.marketwatchsystem.AL.ZoneType;
import com.example.marketwatchsystem.R;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;

public class StatisticPL extends AppCompatActivity implements View.OnClickListener {
    private PieChart pieChart;
    private Button green_btn,red_btn,yellow_btn;
    private RecyclerView recyclerView;
    ArrayList<String> products = new ArrayList<>();
    private ZoneProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        InitializeFields();

        new StatisticsAL().setupPieChart(pieChart);

        red_btn.setOnClickListener(this);
        green_btn.setOnClickListener(this);
        yellow_btn.setOnClickListener(this);
    }

    private void InitializeFields() {
        pieChart = findViewById(R.id.activity_main_piechart);

        green_btn = findViewById(R.id.green_btn);
        red_btn = findViewById(R.id.red_btn);
        yellow_btn = findViewById(R.id.yellow_btn);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ZoneProductAdapter(products,this);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onClick(View v) {
        if(v == red_btn){
            products = HandleZoneAL.deliverInfo(ZoneType.REDZONE);
            red_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_red));
            green_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_button));
            yellow_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_button));
        }
        else if(v == green_btn){
            products = HandleZoneAL.deliverInfo(ZoneType.GREENZONE);
            green_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_green));
            red_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_button));
            yellow_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_button));
        }
        else if(v == yellow_btn){
            products = HandleZoneAL.deliverInfo(ZoneType.YELLOWZONE);
            yellow_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_yello));
            green_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_button));
            red_btn.setBackground(this.getResources().getDrawable(R.drawable.bk_button));
        }
        adapter = new ZoneProductAdapter(products,this);
        recyclerView.setAdapter(adapter);


    }
}