package com.example.aizenonlinesmartshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {



    EditText search_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_bar = findViewById(R.id.search_bar);

    }
}