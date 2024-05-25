package com.example.marketwatchsystem.AL;

import android.content.Context;
import android.widget.Toast;

import com.example.marketwatchsystem.DL.DBHelper;

public class NBRDeptAL implements ShowData {
    Context context;

    public NBRDeptAL(Context context) {
        this.context = context;
    }

    @Override
    public void showToast() {
        Toast.makeText(context, "Enter required info of NBR Dept",
                Toast.LENGTH_SHORT).show();
    }

}
