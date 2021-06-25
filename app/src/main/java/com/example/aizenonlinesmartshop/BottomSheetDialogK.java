package com.example.aizenonlinesmartshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.aizenonlinesmartshop.Login.LoginSignupActivity;
import com.example.aizenonlinesmartshop.Verification.VerificationActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class BottomSheetDialogK extends BottomSheetDialogFragment {

    Button getOtp;
    EditText enterNumber;
    ProgressBar progressBar;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.bottomsheet,container,false);

       getOtp=view.findViewById(R.id.buttonGetOtp);
        enterNumber = view.findViewById(R.id.inputMobile);
        progressBar=view.findViewById(R.id.progressSend);
       getOtp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               if (enterNumber.getText().toString().trim().isEmpty()){
                   Toast.makeText(getContext(), "mymessage ", Toast.LENGTH_SHORT).show();
                   return;
               }
               progressBar.setVisibility(View.VISIBLE);
               getOtp.setVisibility(View.INVISIBLE);

               PhoneAuthProvider.getInstance().verifyPhoneNumber(
                       "+91"+enterNumber.getText().toString(),
                       10,
                       TimeUnit.SECONDS,

                       (Activity) getContext(),
                       new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                           @Override
                           public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
                               progressBar.setVisibility(View.GONE);
                               getOtp.setVisibility(View.VISIBLE);
                           }

                           @Override
                           public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {

                               progressBar.setVisibility(View.GONE);
                               getOtp.setVisibility(View.VISIBLE);
                               Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                           }

                           @Override
                           public void onCodeSent(@NonNull @NotNull String verification, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                               progressBar.setVisibility(View.GONE);
                               getOtp.setVisibility(View.VISIBLE);


                               Intent intent = new Intent(getContext(), VerificationActivity.class);
                               intent.putExtra("mobile", enterNumber.getText().toString());
                               intent.putExtra("verificationId",verification);
                               startActivity(intent);
                           }
                       }
               );

           }


       });

       return view;
    }


}
