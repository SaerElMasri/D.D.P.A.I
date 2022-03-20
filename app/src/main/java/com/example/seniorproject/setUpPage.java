package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class setUpPage extends AppCompatActivity {

    ImageButton returnPage;
    Button connectDevice;
    Button cancelConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_set_up_page);

        returnPage = findViewById(R.id.backButtonSetDevice);
        connectDevice = findViewById(R.id.pairBtn);
        cancelConnection = findViewById(R.id.cancelBtn);


        //Button to return to main page
        returnPage.setOnClickListener(view -> startActivity(new Intent(setUpPage.this, MainPage.class)));


        //Button to set the connection to the device via Bluetooth
        connectDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Connect device via Bluetooth

                Toast.makeText(getApplicationContext(), "Device connection successful!", Toast.LENGTH_SHORT).show();
            }
        });

        //Cancel connection with the device and return to main page
        cancelConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(setUpPage.this, MainPage.class));
            }
        });







    }
}