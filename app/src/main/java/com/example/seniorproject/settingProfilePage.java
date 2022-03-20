package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class settingProfilePage extends AppCompatActivity {

    ImageButton returnPage;
    TextView changePhoto;
    EditText changeName;
    EditText changeEmail;
    EditText changeNumber;
    Button saveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_setting_profile_page);

        returnPage = findViewById(R.id.backButtonForgotPass);
        changePhoto = findViewById(R.id.changePhotoProfile);
        changeName = findViewById(R.id.nameChangeProfile);
        changeEmail = findViewById(R.id.emailChangeProfile);
        changeNumber = findViewById(R.id.phoneChangeProfile);
        saveChanges = findViewById(R.id.editProfileBtn);

        returnPage.setOnClickListener(view -> startActivity(new Intent(settingProfilePage.this, MainPage.class)));
    }
}