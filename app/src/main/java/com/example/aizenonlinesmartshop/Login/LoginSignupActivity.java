package com.example.aizenonlinesmartshop.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aizenonlinesmartshop.Main_Item_Activity;
import com.example.aizenonlinesmartshop.R;
import com.example.aizenonlinesmartshop.Verification.VerificationActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class LoginSignupActivity extends AppCompatActivity {

    EditText enterNumber;
    Button getOtpButton;
    ProgressBar progressBar;
    TextView skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        enterNumber = findViewById(R.id.inputMobile);
        getOtpButton = findViewById(R.id.buttonGetOtp);


        skip=findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginSignupActivity.this, Main_Item_Activity.class));
            }
        });

        progressBar=findViewById(R.id.progressSend);

        getOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (enterNumber.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginSignupActivity.this, "Enter Mobile", Toast.LENGTH_SHORT).show();

                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                getOtpButton.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+enterNumber.getText().toString(),
                        10,
                        TimeUnit.SECONDS,

                        LoginSignupActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                getOtpButton.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {

                                progressBar.setVisibility(View.GONE);
                                getOtpButton.setVisibility(View.VISIBLE);
                                Toast.makeText(LoginSignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull @NotNull String verification, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                getOtpButton.setVisibility(View.VISIBLE);


                                Intent intent = new Intent(LoginSignupActivity.this, VerificationActivity.class);
                                intent.putExtra("mobile", enterNumber.getText().toString());
                                intent.putExtra("verificationId",verification);
                                startActivity(intent);
                            }
                        }
                );

            }

        });

    }
}