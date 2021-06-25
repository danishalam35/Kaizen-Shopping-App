package com.example.aizenonlinesmartshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aizenonlinesmartshop.CategoriesAdapter.MenAdapter;
import com.example.aizenonlinesmartshop.Models.CartModel;
import com.example.aizenonlinesmartshop.Models.MenModel;
import com.example.aizenonlinesmartshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter <CartAdapter.CartViewHolder>{


    ArrayList<CartModel> list;
    Context context;

    public CartAdapter(ArrayList<CartModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @NotNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cart_list,parent,false);
        return new CartAdapter.CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CartViewHolder holder, int position) {

        final CartModel model=list.get(position);
        holder.imk.setImageResource(model.getImageCart());
        holder.productname.setText(String.valueOf(model.getNameProduct()));
        holder.productType.setText(String.valueOf(model.getTypeProduct()));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imk;
        TextView  productname;
        TextView productType;

        public CartViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imk=itemView.findViewById(R.id.cartImage);
            productname=itemView.findViewById(R.id.prT);
            productType=itemView.findViewById(R.id.typeT);

        }
    }
}
