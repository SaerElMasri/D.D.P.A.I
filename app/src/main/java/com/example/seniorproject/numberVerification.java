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

import java.text.BreakIterator;

public class numberVerification extends AppCompatActivity {

    EditText phoneNumber;
    Button nextRegister;
    DatabaseHelper db;
    String fullName, emailUser, pass, _phoneNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_number_verification);

        phoneNumber = findViewById(R.id.numberVerification);
        nextRegister = findViewById(R.id.verificationBtn);
        db = new DatabaseHelper(this);


        //Getting the email from the registration activity to be able to save the phone number into the database
        fullName = getIntent().getStringExtra("username");
        emailUser = getIntent().getStringExtra("emailUser");
        pass = getIntent().getStringExtra("userPass");

        //Number verification back-end process using Firebase approach
        nextRegister.setOnClickListener(view -> {

            //Getting the phone number from the user
            _phoneNo = phoneNumber.getText().toString();

            if(_phoneNo.trim().equals("")){
                Toast.makeText(getApplicationContext(), "Please fill the required information", Toast.LENGTH_SHORT).show();
            }else{
                boolean dataInserted = db.Insert(fullName, emailUser, pass, _phoneNo);
                if(dataInserted == true){
                    Intent i = new Intent(numberVerification.this, VerifiedNumber.class);
                    Toast.makeText(getApplicationContext(), "User saved successfully", Toast.LENGTH_SHORT).show();
                    i.putExtra("phoneNo",_phoneNo.trim());
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}