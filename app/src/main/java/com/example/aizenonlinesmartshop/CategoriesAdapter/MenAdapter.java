package com.example.aizenonlinesmartshop.CategoriesAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aizenonlinesmartshop.Adapters.IconAdapter;
import com.example.aizenonlinesmartshop.Models.Item;
import com.example.aizenonlinesmartshop.Models.MenModel;
import com.example.aizenonlinesmartshop.Preiview.Men_Preview_Activity;
import com.example.aizenonlinesmartshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MenAdapter extends RecyclerView.Adapter<MenAdapter.MenViewHolder> {

    ArrayList<MenModel> list;
    Context context;

    public MenAdapter(ArrayList<MenModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public MenViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_mens,parent,false);
        return new MenAdapter.MenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MenViewHolder holder, int position) {
        final MenModel model=list.get(position);
        holder.pr.setImageResource(model.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Men_Preview_Activity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MenViewHolder extends RecyclerView.ViewHolder {

        ImageView pr;

        public MenViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            pr=itemView.findViewById(R.id.hghj);



        }
    }
}
