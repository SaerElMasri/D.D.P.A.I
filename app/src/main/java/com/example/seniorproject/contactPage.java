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

public class contactPage extends AppCompatActivity {

    ImageButton returnPage;
    TextView editBtn;
    Button addContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contact_page);

        returnPage = findViewById(R.id.backButtonContact);
        editBtn = findViewById(R.id.editPhoneNumber);
        addContactBtn = findViewById(R.id.addContactBtn);

        returnPage.setOnClickListener(view -> startActivity(new Intent(contactPage.this, MainPage.class)));

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(contactPage.this, addContactPage.class));
            }
        });

        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(contactPage.this, addContactPage.class));
            }
        });
    }
}