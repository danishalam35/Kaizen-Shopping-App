package com.example.aizenonlinesmartshop.Catefories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.aizenonlinesmartshop.Adapters.SliderAdapter;
import com.example.aizenonlinesmartshop.CategoriesAdapter.MenAdapter;
import com.example.aizenonlinesmartshop.Models.MenModel;
import com.example.aizenonlinesmartshop.Models.SliderData;
import com.example.aizenonlinesmartshop.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MenActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenAdapter menAdapter;

    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        sliderView=findViewById(R.id.slider);
        recyclerView=findViewById(R.id.recycler_view);




        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();



        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(R.drawable.vbvhesrt));
        sliderDataArrayList.add(new SliderData(R.drawable.ghfhtdhtd));
        sliderDataArrayList.add(new SliderData(R.drawable.beautysad));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(getApplicationContext(), sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();




        ArrayList<MenModel> list=new ArrayList<>();

        list.add(new MenModel(R.drawable.bnhc));
        list.add(new MenModel(R.drawable.jfjyg));
        list.add(new MenModel(R.drawable.fhj));
        list.add(new MenModel(R.drawable.fhj));
        list.add(new MenModel(R.drawable.bnhc));
        list.add(new MenModel(R.drawable.jfjyg));
        list.add(new MenModel(R.drawable.bnhc));
        list.add(new MenModel(R.drawable.jfjyg));




         menAdapter=new MenAdapter(list,this);


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(menAdapter);

    }
}