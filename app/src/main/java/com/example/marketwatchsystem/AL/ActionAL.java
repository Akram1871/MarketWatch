package com.example.marketwatchsystem.AL;

import android.content.Context;

import com.example.marketwatchsystem.DL.DBHelper;

import java.util.ArrayList;

public class ActionAL {
    private ArrayList<ProductInfo> products;
    private ArrayList<String> productName;
    private ArrayList<String> productCode;

    public ArrayList<ProductInfo> takeAction(Context context){
        DBHelper mydb = new DBHelper(context);
        productName = mydb.getAllProductNames();
        productCode = mydb.getAllProductCodes();
        products = new ArrayList<>();


        if(productName.size() > 0){
            for(int i=0 ; i<productName.size() ; i++){
                ProductInfo productInfo = new ProductInfo(
                        productName.get(i),productCode.get(i), mydb.getMessage(String.valueOf(productCode.get(i)))
                );
                products.add(productInfo);
            }
        }
        return products;
    }
}
