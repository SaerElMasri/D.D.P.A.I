package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ForgotPassword extends AppCompatActivity {

    EditText email;
    Button sendButton;
    ImageButton returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgot_password);

        returnButton = findViewById(R.id.backButtonForgotPass);
        email = findViewById(R.id.editTextEmailForgotPass);
        sendButton = findViewById(R.id.sendButtonForgotPass);

        email.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);


        sendButton.setOnClickListener(view -> {
            String emailUser = email.getText().toString();

            //Send a link to change the password
        });

        returnButton.setOnClickListener(view -> startActivity(new Intent(ForgotPassword.this, loginPage.class)));
    }
}