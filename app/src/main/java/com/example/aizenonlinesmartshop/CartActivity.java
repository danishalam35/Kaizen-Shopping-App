package com.example.aizenonlinesmartshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aizenonlinesmartshop.Adapters.CartAdapter;
import com.example.aizenonlinesmartshop.CategoriesAdapter.MenAdapter;
import com.example.aizenonlinesmartshop.Models.CartModel;
import com.example.aizenonlinesmartshop.Models.MenModel;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    ImageView back;
    CartAdapter cartAdapter;
    ArrayList<CartModel> list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        back=findViewById(R.id.back);
        recyclerView=findViewById(R.id.recycler_view);




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main_Item_Activity.class));
            }
        });


        list=new ArrayList<>();
        list.add(new CartModel(R.drawable.bnhc,"Lehnga","Stylish"));
        list.add(new CartModel(R.drawable.bnhc,"Long","Stylish Shoot"));
        list.add(new CartModel(R.drawable.bnhc,"fjhg","hfjh"));
        list.add(new CartModel(R.drawable.bnhc,"gfdgf","yfhjhv"));
        list.add(new CartModel(R.drawable.bnhc,"fxgfxf","gfgfnc"));
        list.add(new CartModel(R.drawable.bnhc,"hchgcng","chgchng"));
        list.add(new CartModel(R.drawable.bnhc,"gfgfg","ghhv"));

        cartAdapter=new CartAdapter(list,this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(cartAdapter);


}
}