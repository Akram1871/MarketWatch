package com.example.marketwatchsystem.PL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.marketwatchsystem.AL.DistributeInfoAL;
import com.example.marketwatchsystem.R;
import com.google.android.material.textfield.TextInputEditText;

public class DistributeInfoPL extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText edit_text_product_name, edit_text_product_code;
    private Button btn_send;
    private Spinner spinner_select_dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribute_info);

        init();
        btn_send.setOnClickListener(this);
    }


    public void init(){
        edit_text_product_name = findViewById(R.id.edit_text_prd_name);
        edit_text_product_code = findViewById(R.id.edit_text_prd_code);
        btn_send = findViewById(R.id.btn_send);
        spinner_select_dept = findViewById(R.id.spinner_select_dept);
    }

    @Override
    public void onClick(View view) {
        new DistributeInfoAL().sendInfo(edit_text_product_name.getText().toString(),
                edit_text_product_code.getText().toString(),this,spinner_select_dept.toString());
    }

}