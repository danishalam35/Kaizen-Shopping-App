package com.example.aizenonlinesmartshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aizenonlinesmartshop.Models.ImageOffer;
import com.example.aizenonlinesmartshop.Models.Offer;
import com.example.aizenonlinesmartshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ImageAdapter  extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{


    private ArrayList<ImageOffer> list;
    private Context context;

    public ImageAdapter(ArrayList<ImageOffer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_category,parent,false);
        return new ImageAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ImageViewHolder holder, int position) {


        final ImageOffer model=list.get(position);
        holder.im1.setImageResource(model.getImageData());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView im1;

        public ImageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            im1=itemView.findViewById(R.id.image_offer);

        }
    }
}
