package com.example.aizenonlinesmartshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aizenonlinesmartshop.Models.ImageOffer;
import com.example.aizenonlinesmartshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemHomeAdapter  extends RecyclerView.Adapter<ItemHomeAdapter.HomeHolder>{

    private ArrayList<ImageOffer> list;
    private Context context;

    public ItemHomeAdapter(ArrayList<ImageOffer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_home,parent,false);
        return new ItemHomeAdapter.HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeHolder holder, int position) {


        final ImageOffer model=list.get(position);
        holder.it1.setImageResource(model.getImageData());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class HomeHolder extends RecyclerView.ViewHolder {

        ImageView it1;
        public HomeHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            it1=itemView.findViewById(R.id.imgdy);
        }
    }
}
