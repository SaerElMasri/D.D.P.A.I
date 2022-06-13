package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    TextView welcomeUser;
    TextView alcoholMsg;
    ImageButton settingButton;
    ImageView setupBtn;
    ImageView contactBtn;
    ImageView testBtn;
    ImageView locationBtn;
    ImageView logout;
    String emailToSettingProfile;

    //private ProgressBar progressBarMainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_page);

        welcomeUser = findViewById(R.id.buttons_sma);
        alcoholMsg = findViewById(R.id.text_mainPage);
        settingButton = findViewById(R.id.settingBtn);
        setupBtn = findViewById(R.id.setupButton);
        contactBtn = findViewById(R.id.contactButton);
        testBtn = findViewById(R.id.testButton);
        locationBtn = findViewById(R.id.locationButton);
        logout = findViewById(R.id.logOutBtn);

        emailToSettingProfile = getIntent().getStringExtra("emailToChangeProfile");


        //progressBarMainPage = findViewById(R.id.progressBar);

        //Alcohol percentage taken from the Breathalyzer and stored it into the DB
        //Double alcoholPercentage = 0.0;
        //This percentage appended to the default text
        //alcoholMsg.setText("Breath Alcohol Concentration levels on " + alcoholPercentage);


        //Setting button
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, settingProfilePage.class);

                //Pass the phone number to the next activity
                intent.putExtra("emailToChange",emailToSettingProfile);
                startActivity(intent);
            }
        });

        //Set up button
        setupBtn.setOnClickListener(view -> startActivity(new Intent(MainPage.this, setUpPage.class)));

        //Contact button
        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, contactActivity.class);
                intent.putExtra("emailToChange",emailToSettingProfile);
                startActivity(intent);
            }
        });

        //Show test taken button
        testBtn.setOnClickListener(view -> startActivity(new Intent(MainPage.this, testPage.class)));

        //Location button
        locationBtn.setOnClickListener(view -> startActivity(new Intent(MainPage.this, locationPage.class)));

        //Logout button
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainPage.this,loginPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

    }
}