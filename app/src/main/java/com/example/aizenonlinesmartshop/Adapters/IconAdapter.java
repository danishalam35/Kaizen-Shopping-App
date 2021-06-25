package com.example.aizenonlinesmartshop.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aizenonlinesmartshop.Catefories.MenActivity;
import com.example.aizenonlinesmartshop.Models.Item;
import com.example.aizenonlinesmartshop.R;

import java.util.ArrayList;

public class IconAdapter  extends RecyclerView.Adapter<IconAdapter.MyViewHolder>{


    private ArrayList<Item> list;
    private  Context context;

    public IconAdapter(ArrayList<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_cat,parent,false);
        return new IconAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Item model=list.get(position);
        holder.img.setImageResource(model.getImage());
        holder.item.setText(String.valueOf(model.getItem_name()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MenActivity.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView item;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.item_image);
            item=itemView.findViewById(R.id.item_name);


        }
    }
}
