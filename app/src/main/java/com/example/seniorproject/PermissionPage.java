package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class PermissionPage extends AppCompatActivity {

    CheckBox locationBox;
    CheckBox cameraBox;
    CheckBox contactBox;
    CheckBox policyBox;
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_permission_page);

        locationBox = findViewById(R.id.checkBoxLocation);
        cameraBox = findViewById(R.id.checkBoxCamera);
        contactBox = findViewById(R.id.checkBoxContacts);
        policyBox = findViewById(R.id.policyBox);
        continueButton = findViewById(R.id.buttonContinuePermission);



        continueButton.setOnClickListener(view -> {
            startActivity(new Intent(PermissionPage.this, FacialDetection.class));
        });

    }
}