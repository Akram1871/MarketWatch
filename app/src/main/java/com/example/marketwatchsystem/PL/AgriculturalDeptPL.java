package com.example.marketwatchsystem.PL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marketwatchsystem.DL.DBHelper;
import com.example.marketwatchsystem.R;
import com.google.android.material.textfield.TextInputEditText;

public class AgriculturalDeptPL extends AppCompatActivity implements InsertData {
    private TextInputEditText edit_text_supply, edit_text_demand,
            edit_text_source, edit_text_production;
    private Button btn_add,btn_update;
    private Spinner spinner_select_prd,spinner_select_prdCd;
    private DBHelper mydb ;
    public static AgriculturalDeptPL INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agricultural_dept);
        mydb = new DBHelper(this);
        INSTANCE = this;
        init();

        loadInfo();

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDataIntoDb();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               updateDataIntoDb();
            }
        });

        Intent intent = getIntent();
        if(intent.getStringExtra("type").equals("add")){
            btn_update.setVisibility(View.GONE);
        }
        else  if(intent.getStringExtra("type").equals("update")){
            btn_add.setVisibility(View.GONE);
        }
    }

    @Override
    public void addDataIntoDb() {
        if(mydb.insertAgri(spinner_select_prd.getSelectedItem().toString(),spinner_select_prdCd.getSelectedItem().toString(),
                edit_text_supply.getText().toString(),edit_text_demand.getText().toString(),edit_text_source.getText().toString(),
                edit_text_production.getText().toString())){
            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateDataIntoDb() {
        if(mydb.updateAgri(spinner_select_prd.getSelectedItem().toString(),spinner_select_prdCd.getSelectedItem().toString(),
                edit_text_supply.getText().toString(),edit_text_demand.getText().toString(),edit_text_source.getText().toString(),
                edit_text_production.getText().toString())){
            Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadInfo() {
        ArrayAdapter<String> productName =new ArrayAdapter<String>(AgriculturalDeptPL.this,android.R.layout.simple_spinner_item,
                mydb.getAllProductNames());
        productName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_select_prd.setAdapter(productName);

        ArrayAdapter<String> productCode =new ArrayAdapter<String>(AgriculturalDeptPL.this,android.R.layout.simple_spinner_item,
                mydb.getAllProductCodes());
        productCode.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_select_prdCd.setAdapter(productCode);
    }


    public void init(){
        btn_add = findViewById(R.id.btn_add_agri);
        btn_update = findViewById(R.id.btn_update_agri);
        spinner_select_prd = findViewById(R.id.spinner_select_prd_agri);
        spinner_select_prdCd = findViewById(R.id.spinner_select_prdCd_agri);

        edit_text_supply = findViewById(R.id.edit_text_supply);
        edit_text_demand = findViewById(R.id.edit_text_demand);
        edit_text_source = findViewById(R.id.edit_text_source);
        edit_text_production = findViewById(R.id.edit_text_prduction);
    }
}