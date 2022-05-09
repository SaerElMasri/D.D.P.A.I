package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ImpairedRegistration extends AppCompatActivity {
    EditText information1;
    EditText information2;
    EditText information3;
    RadioButton userGlasses;
    RadioButton noGlasses;
    RadioButton withProb;
    RadioButton noProb;
    Button nextRegister;
    String prescriptionGlass = "";
    String hearingProblems = "";

    //Variables for data from intent
    String fullName, email, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_impaired_registration);

        information1 = findViewById(R.id.info1);
        information2 = findViewById(R.id.info2);
        information3 = findViewById(R.id.info3);
        userGlasses = findViewById(R.id.use);
        noGlasses = findViewById(R.id.noUse);
        withProb = findViewById(R.id.yes);
        noProb = findViewById(R.id.dont);
        nextRegister = findViewById(R.id.next);

        //Getting the intent extra from the intent
        fullName = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("emailUser");
        pass = getIntent().getStringExtra("userPass");


        nextRegister.setOnClickListener(view -> {
            String info1 = information1.getText().toString();
            String info2 = information2.getText().toString();
            String info3 = information3.getText().toString();

            if(info1.equals("") || info3.equals("")){
                Toast.makeText(getApplicationContext(), "Please fill the required information", Toast.LENGTH_SHORT).show();
            }else{
                if(userGlasses.isChecked()){
                    prescriptionGlass = userGlasses.getText().toString();
                }else if(noGlasses.isChecked()){
                    prescriptionGlass = noGlasses.getText().toString();
                }
                if(withProb.isChecked()){
                    hearingProblems = withProb.getText().toString();
                }else if(noProb.isChecked()){
                    hearingProblems = noProb.getText().toString();
                }

                Intent intent = new Intent(ImpairedRegistration.this, numberVerification.class);
                intent.putExtra("username", fullName);
                intent.putExtra("emailUser",email);
                intent.putExtra("userPass", pass);
                startActivity(intent);
            }
        });

    }


}