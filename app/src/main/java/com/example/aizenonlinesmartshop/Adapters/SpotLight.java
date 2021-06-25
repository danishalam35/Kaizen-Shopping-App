package com.example.aizenonlinesmartshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aizenonlinesmartshop.Models.Offer;
import com.example.aizenonlinesmartshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SpotLight extends RecyclerView.Adapter<SpotLight.MySpotViewHolder> {
    private ArrayList<Offer> mList;
    private Context context;

    public SpotLight(ArrayList<Offer> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MySpotViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_spotlight,parent,false);
        return new SpotLight.MySpotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MySpotViewHolder holder, int position) {

        final Offer model=mList.get(position);
        holder.img1.setImageResource(model.getOfferImage());
        holder.tv1.setText(String.valueOf(model.getProduct_name()));
        holder.tv2.setText(String.valueOf(model.getOfferDetail()));


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MySpotViewHolder extends RecyclerView.ViewHolder {

        ImageView img1;
        TextView tv1,tv2;
        public MySpotViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.item_spot);
            tv1=itemView.findViewById(R.id.name_spot);
            tv2=itemView.findViewById(R.id.spot_rupees);
        }
    }
}
