package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Description1 extends AppCompatActivity {

    TextView skip;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_description1);

        skip = findViewById(R.id.click);
        next = findViewById(R.id.buttonNext);

        next.setOnClickListener(view -> startActivity(new Intent(Description1.this, Description2.class)));

        skip.setOnClickListener(view -> startActivity(new Intent(Description1.this, RegistrationPage.class)));


    }
}