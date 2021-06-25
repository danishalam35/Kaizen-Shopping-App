package com.example.aizenonlinesmartshop.Verification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aizenonlinesmartshop.Fragments.ProfileFragment;
import com.example.aizenonlinesmartshop.Login.CreateActivity;
import com.example.aizenonlinesmartshop.Login.LoginSignupActivity;
import com.example.aizenonlinesmartshop.Main_Item_Activity;
import com.example.aizenonlinesmartshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class VerificationActivity extends AppCompatActivity {

    EditText inputNumber1,inputNumber2,inputNumber3,inputNumber4,inputNumber5,inputNumber6;

    private static final Boolean isLogout=true;
    ProgressBar progressBar;
    Button verifyButton;
    TextView textMobile,verify;
    private String verificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        inputNumber1 = findViewById(R.id.inputOtp1);
        inputNumber2 = findViewById(R.id.inputOtp2);
        inputNumber3 = findViewById(R.id.inputOtp3);
        inputNumber4 = findViewById(R.id.inputOtp4);
        inputNumber5 = findViewById(R.id.inputOtp5);
        inputNumber6 = findViewById(R.id.inputOtp6);
        verify=findViewById(R.id.resend);

        progressBar=findViewById(R.id.progressVerify);
        setOtp();
        textMobile=findViewById(R.id.textMobileNumberShow);

        textMobile.setText(String.format(
                "+91-%s",getIntent().getStringExtra("mobile")
        ));

        verifyButton=findViewById(R.id.verifyGetOtp);
        verificationId=getIntent().getStringExtra("verificationId");
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputNumber1.getText().toString().trim().isEmpty()
                        ||inputNumber2.getText().toString().trim().isEmpty()
                        ||inputNumber3.getText().toString().trim().isEmpty()
                        ||inputNumber4.getText().toString().trim().isEmpty()
                        ||inputNumber5.getText().toString().trim().isEmpty()
                        ||inputNumber2.getText().toString().trim().isEmpty()){

                    Toast.makeText(VerificationActivity.this, "Please Enter Valid Code", Toast.LENGTH_SHORT).show();
                    return;
                }
                String code =inputNumber1.getText().toString()+
                        inputNumber2.getText().toString()+
                        inputNumber3.getText().toString()+
                        inputNumber4.getText().toString()+
                        inputNumber5.getText().toString()+
                        inputNumber6.getText().toString();
                if (verificationId !=null){
                    progressBar.setVisibility(View.VISIBLE);
                    verifyButton.setVisibility(View.INVISIBLE);

                    PhoneAuthCredential phoneAuthCredential=PhoneAuthProvider.getCredential(
                            verificationId,
                            code
                    );
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.GONE);
                                    verifyButton.setVisibility(View.VISIBLE);

                                    if (task.isSuccessful()){

                                        Intent intent=new Intent(getApplicationContext(), Main_Item_Activity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(VerificationActivity.this, "Invalid Code", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+getIntent().getStringExtra("mobile"),
                        10,
                        TimeUnit.SECONDS,

                        VerificationActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {



                            }

                            @Override
                            public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {


                                Toast.makeText(VerificationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull @NotNull String newVerification, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {


                              verificationId=newVerification;
                                Toast.makeText(VerificationActivity.this, "Otp sent", Toast.LENGTH_SHORT).show();
                            }
                        }
                );

            }
        });



        }

        private void setOtp(){

        inputNumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!s.toString().trim().isEmpty()){
                    inputNumber2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

            inputNumber2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (!s.toString().trim().isEmpty()){
                        inputNumber3.requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            inputNumber3.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (!s.toString().trim().isEmpty()){
                        inputNumber4.requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            inputNumber4.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (!s.toString().trim().isEmpty()){
                        inputNumber5.requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            inputNumber5.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    if (!s.toString().trim().isEmpty()){
                        inputNumber6.requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });



        }


    }

