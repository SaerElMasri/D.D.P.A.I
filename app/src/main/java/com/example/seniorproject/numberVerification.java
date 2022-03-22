package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class numberVerification extends AppCompatActivity {

    EditText phoneNumber;
    Button nextRegister;
    CountryCodePicker ccp;
    String _phoneNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_number_verification);

        phoneNumber = findViewById(R.id.numberVerification);
        nextRegister = findViewById(R.id.verificationBtn);
        ccp = findViewById(R.id.countryCode_picker);






        nextRegister.setOnClickListener(view -> {
            if(phoneNumber.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill the required information", Toast.LENGTH_SHORT).show();
            }else{

                //_phoneNo = "+"+ccp.getFullNumber() + getUserPhoneNumber;

                Intent intent = new Intent(numberVerification.this, VerifiedNumber.class);

                //Pass the phone number to the next activity
                intent.putExtra("phoneNo",phoneNumber.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}