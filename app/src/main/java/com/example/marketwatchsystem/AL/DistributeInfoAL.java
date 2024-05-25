package com.example.marketwatchsystem.AL;

import android.content.Context;
import android.widget.Toast;

public class DistributeInfoAL {
    public void sendInfo(String product_name, String product_code, Context context,String select_dept){
        SendInfo si = new Builder(product_name,product_code,context).
                setDept(select_dept).Build();

        if(si.send()){
            Toast.makeText(context, "done",
                    Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(context, "not done",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
