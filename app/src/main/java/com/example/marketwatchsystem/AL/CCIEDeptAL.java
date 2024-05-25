package com.example.marketwatchsystem.AL;

import android.content.Context;
import android.widget.Toast;

import com.example.marketwatchsystem.DL.DBHelper;

public class CCIEDeptAL implements ShowData {
    Context context;

    public CCIEDeptAL(Context context) {
        this.context = context;
    }

    @Override
    public void showToast() {
        Toast.makeText(context, "Enter required info of CCIE Dept",
                Toast.LENGTH_SHORT).show();
    }

}
