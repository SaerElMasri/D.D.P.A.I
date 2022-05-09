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
import android.widget.Toast;

public class settingProfilePage extends AppCompatActivity {

    ImageButton returnPage;
    EditText changePass;
    Button saveChanges;
    DatabaseHelper db;
    String emailToSettingProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_setting_profile_page);

        returnPage = findViewById(R.id.backButtonForgotPass);
        changePass = findViewById(R.id.passChangeProfile);
        saveChanges = findViewById(R.id.editProfileBtn);

        db = new DatabaseHelper(this);

        String newPass = changePass.getText().toString();

        //Getting the user email from loginPage activity
        emailToSettingProfile = getIntent().getStringExtra("emailToChange");

        //Update the user profile
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.updatePassword(emailToSettingProfile, newPass);
                Toast.makeText(settingProfilePage.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
            }
        });

        //Return to app dashboard
        returnPage.setOnClickListener(view -> startActivity(new Intent(settingProfilePage.this, MainPage.class)));
    }
}