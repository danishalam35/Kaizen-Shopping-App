package com.example.aizenonlinesmartshop.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.aizenonlinesmartshop.BottomSheetDialogK;
import com.example.aizenonlinesmartshop.Login.LoginSignupActivity;
import com.example.aizenonlinesmartshop.Main_Item_Activity;
import com.example.aizenonlinesmartshop.R;
import com.example.aizenonlinesmartshop.Verification.VerificationActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;


public class ProfileFragment extends Fragment {

    Button login;
    private boolean isLogin = true;
    private static final String TEXT_LOGOUT = "Logout";

    EditText enterNumber;
    Button getOtpButton;
    ProgressBar progressBar;

    TextView logout;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        login=view.findViewById(R.id.loginSignup);
        logout=view.findViewById(R.id.logiout);

        login.setVisibility(View.VISIBLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                BottomSheetDialogK bottomSheetDialogK=new BottomSheetDialogK();
                bottomSheetDialogK.show(getFragmentManager(),"Example Bottom");



            }

        });


        return view;
    }




}