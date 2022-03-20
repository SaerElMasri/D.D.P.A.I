package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Description3 extends AppCompatActivity {

    TextView skip;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_description3);

        skip = findViewById(R.id.skipDesription);
        next = findViewById(R.id.buttonNext3);

        next.setOnClickListener(view -> startActivity(new Intent(Description3.this, WelcomePage.class)));

        skip.setOnClickListener(view -> startActivity(new Intent(Description3.this, RegistrationPage.class)));
    }
}