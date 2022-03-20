package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class VerifiedNumber extends AppCompatActivity {

    ImageButton returnPage;
    EditText FirstNumber;
    EditText SecondNumber;
    EditText ThirdNumber;
    EditText ForthNumber;
    TextView resendCode;
    Button continueRegister;
    String verificationCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_verified_number);

        returnPage = findViewById(R.id.returnPag);
        FirstNumber =findViewById(R.id.codeFirstNumber);
        SecondNumber =findViewById(R.id.codeSecondNumber);
        ThirdNumber =findViewById(R.id.codeThirdNumber);
        ForthNumber =findViewById(R.id.codeForthNumber);
        resendCode = findViewById(R.id.resend);
        continueRegister = findViewById(R.id.buttonContinueVerification);


        continueRegister.setOnClickListener(view -> {
            String first = FirstNumber.toString();
            String second = SecondNumber.toString();
            String third = ThirdNumber.toString();
            String forth = ForthNumber.toString();

            verificationCode += first + second + third + forth;

            //Check if the code that the user added is the same as the one were send.
            //Code here
            //if the code from the user is the same as the original one, the button will let go to the other activity
            //if it's not a code will be sent again

            startActivity(new Intent(VerifiedNumber.this, RegistrationDone.class));
        });

        resendCode.setOnClickListener(view -> {
            //Resend code
        });

        returnPage.setOnClickListener(view -> startActivity(new Intent(VerifiedNumber.this, numberVerification.class)));





    }
}