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
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    EditText emailForgotPass;
    Button sendButton;
    ImageButton returnButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgot_password);

        returnButton = findViewById(R.id.backButtonForgotPass);
        emailForgotPass = findViewById(R.id.editTextEmailForgotPass);
        sendButton = findViewById(R.id.sendButtonForgotPass);
        databaseHelper = new DatabaseHelper(this);

        emailForgotPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);


        sendButton.setOnClickListener(view -> {
            String emailToCheck = emailForgotPass.getText().toString();
            if(!emailToCheck.isEmpty()){
                Boolean checkEmail = databaseHelper.checkAlreadyExist(emailToCheck);
                if(checkEmail == true){
                    Toast.makeText(ForgotPassword.this, "User found", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgotPassword.this, ResetPassword.class);
                    intent.putExtra("emailToForgotPass", emailToCheck);
                    startActivity(intent);
                }else{
                    Toast.makeText(ForgotPassword.this, "User does not exists", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(ForgotPassword.this, "Please fill up the required information", Toast.LENGTH_SHORT).show();
            }

        });

        returnButton.setOnClickListener(view -> startActivity(new Intent(ForgotPassword.this, loginPage.class)));
    }
}