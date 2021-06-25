package com.example.aizenonlinesmartshop.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aizenonlinesmartshop.Main_Item_Activity;
import com.example.aizenonlinesmartshop.R;
import com.google.android.material.textfield.TextInputEditText;

public class CreateActivity extends AppCompatActivity {

    TextInputEditText eName,eMobile,eAddress,eCity,eLocality,ePin,eState;

    Button addAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        eName=findViewById(R.id.eName);
        eMobile=findViewById(R.id.eMobile);
        eAddress=findViewById(R.id.eAddress);
        eCity=findViewById(R.id.eCity);
        eLocality=findViewById(R.id.eLocality);
        ePin=findViewById(R.id.ePin);
        eState=findViewById(R.id.eState);
        addAddress=findViewById(R.id.addAddress);


        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateActivity.this, Main_Item_Activity.class));
            }
        });


    }
}