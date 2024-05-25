package com.example.marketwatchsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marketwatchsystem.AL.UserType;
import com.example.marketwatchsystem.PL.ActionPL;
import com.example.marketwatchsystem.PL.DistributeInfoPL;
import com.example.marketwatchsystem.PL.SelectDepartmentPL;
import com.example.marketwatchsystem.PL.StatisticPL;

public class Client extends AppCompatActivity implements View.OnClickListener{
    private Button button1,button2,button3,btn_submit,btn_modify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(UserType.getUserTypeInstance().getType().equals("Admin")){
            findViewById(R.id.relativeLayout2).setVisibility(View.GONE);
            findViewById(R.id.relativeLayout1).setVisibility(View.VISIBLE);
        }
        else  if(UserType.getUserTypeInstance().getType().equals("NonAdmin")){
            findViewById(R.id.relativeLayout1).setVisibility(View.GONE);
            findViewById(R.id.relativeLayout2).setVisibility(View.VISIBLE);
        }

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        btn_submit = findViewById(R.id.button4);
        btn_modify = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
        btn_modify.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finishAndRemoveTask();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1 :
                Intent intent = new Intent(Client.this, DistributeInfoPL.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(Client.this, StatisticPL.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(Client.this, ActionPL.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent(Client.this, SelectDepartmentPL.class);
                intent4.putExtra("message","add");
                startActivity(intent4);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(Client.this, SelectDepartmentPL.class);
                intent5.putExtra("message","update");
                startActivity(intent5);
                break;
        }
    }
}