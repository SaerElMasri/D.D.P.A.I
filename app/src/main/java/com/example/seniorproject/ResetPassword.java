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

public class ResetPassword extends AppCompatActivity {

    TextView email;
    EditText newPass;
    EditText newPassConfirm;
    Button recoverBtn;
    ImageButton returnPage;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reset_password);

        email = findViewById(R.id.emailRecoveryPass);
        newPass = findViewById(R.id.passRecoveryPass);
        newPassConfirm = findViewById(R.id.confirmPassRecoveryPass);
        recoverBtn = findViewById(R.id.recoverButton);
        returnPage = findViewById(R.id.backButtonRecovery);
        db = new DatabaseHelper(this);

        String emailFromIntent = getIntent().getStringExtra("emailToForgotPass");
        email.setText(emailFromIntent);



        recoverBtn.setOnClickListener(view -> {
            String newPassVariable = newPass.getText().toString();
            String confirmPassVariable = newPassConfirm.getText().toString();

            if(newPassVariable.isEmpty() && confirmPassVariable.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please fill up all the required spaces", Toast.LENGTH_SHORT).show();
            }else{
                if(!newPassVariable.equals(confirmPassVariable)){
                    Toast.makeText(getApplicationContext(), "Passwords do not match, try again", Toast.LENGTH_SHORT).show();
                }else{
                    db.updatePassword(emailFromIntent, newPassVariable);
                    Toast.makeText(getApplicationContext(), "Password Updated Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPassword.this, loginPage.class);
                    startActivity(intent);
                }
            }
        });

        returnPage.setOnClickListener(view -> {
            Intent i = new Intent(ResetPassword.this, ForgotPassword.class);
            startActivity(i);
        });


    }
}