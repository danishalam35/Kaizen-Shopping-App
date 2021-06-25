package com.example.aizenonlinesmartshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
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

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyOfferViewHolder> {

    private ArrayList<Offer> list;
    private Context context;

    public OfferAdapter(ArrayList<Offer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MyOfferViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.main_list,parent,false);
        return new OfferAdapter.MyOfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyOfferViewHolder holder, int position) {

        final Offer model=list.get(position);
        holder.offerImage.setImageResource(model.getOfferImage());
        holder.offerName.setText(String.valueOf(model.getProduct_name()));
        holder.offerRate.setText(String.valueOf(model.getOfferDetail()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyOfferViewHolder extends RecyclerView.ViewHolder {

        ImageView offerImage;
        TextView offerName,offerRate;


        public MyOfferViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            offerImage=itemView.findViewById(R.id.offerImage);
            offerName=itemView.findViewById(R.id.offer_name);
            offerRate=itemView.findViewById(R.id.offer_Rate);


        }
    }
}
