package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Description2 extends AppCompatActivity {

    TextView skip;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_description2);

        skip = findViewById(R.id.clickDescription2);
        next = findViewById(R.id.buttonNext2);

        //Next screen which is Description 2
        next.setOnClickListener(view -> startActivity(new Intent(Description2.this, Description3.class)));

        //Skip to the registration part
        skip.setOnClickListener(view -> startActivity(new Intent(Description2.this, RegistrationPage.class)));
    }
}