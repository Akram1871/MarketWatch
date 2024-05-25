package com.example.marketwatchsystem.PL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketwatchsystem.R;

import java.util.ArrayList;

public class ZoneProductAdapter extends RecyclerView.Adapter<ZoneProductAdapter.ViewHolder>{
    private ArrayList<String> products;
    private Context context;

    public ZoneProductAdapter(ArrayList<String> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ZoneProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_zone_product,parent, false);

        return new ZoneProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZoneProductAdapter.ViewHolder holder, int position) {
        holder.name.setText(products.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
        }
    }
}
