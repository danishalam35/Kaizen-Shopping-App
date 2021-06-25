package com.example.aizenonlinesmartshop.Preiview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aizenonlinesmartshop.Adapters.SliderAdapter;
import com.example.aizenonlinesmartshop.Models.SliderData;
import com.example.aizenonlinesmartshop.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Men_Preview_Activity extends AppCompatActivity {



    SliderView sliderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_preview);

        sliderView=findViewById(R.id.sliders);


        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();



        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(R.drawable.mens));
        sliderDataArrayList.add(new SliderData(R.drawable.mens));
        sliderDataArrayList.add(new SliderData(R.drawable.mens));

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


        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(false);

        // to start autocycle below method is used.



    }
}