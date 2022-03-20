package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class numberVerification extends AppCompatActivity {

    EditText phoneNumber;
    Button nextRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_number_verification);

        phoneNumber = findViewById(R.id.numberVerification);
        nextRegister = findViewById(R.id.verificationBtn);

        nextRegister.setOnClickListener(view -> {
            if(phoneNumber.equals("")){
                Toast.makeText(getApplicationContext(), "Please fill the required information", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(new Intent(numberVerification.this, VerifiedNumber.class));
            }
        });
    }
}