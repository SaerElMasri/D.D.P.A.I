package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LoginSuccessful extends AppCompatActivity {

    Button successLog;
    String emailToSettingProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_successful);


        emailToSettingProfile = getIntent().getStringExtra("emailToChangeProfile");

        successLog = findViewById(R.id.successLog);

        successLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessful.this, MainPage.class);

                //Pass the phone number to the next activity
                intent.putExtra("emailToChangeProfile",emailToSettingProfile);
                startActivity(intent);
            }
        });

    }
}