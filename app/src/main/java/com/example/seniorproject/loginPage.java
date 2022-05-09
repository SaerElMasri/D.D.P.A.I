package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class loginPage extends AppCompatActivity {

    //Variables
    EditText userEmail;
    EditText userPassword;
    TextView forgotPassword;
    Button loginButton;
    TextView registerNewUser;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_page);

        //Hook up for the layout
        userEmail = findViewById(R.id.editTextEmailLog);
        userPassword = findViewById(R.id.editTextPasswordLog);
        forgotPassword = findViewById(R.id.forgot_pass);
        loginButton = findViewById(R.id.logButton);
        registerNewUser = findViewById(R.id.registerNew);
        databaseHelper = new DatabaseHelper(this);

        userEmail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        userPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        loginButton.setOnClickListener(view -> {
            String email = userEmail.getText().toString();
            String password = userPassword.getText().toString();

            Boolean checkLogin = databaseHelper.CheckLogin(email, password);
            if(checkLogin == true){
                Intent i = new Intent(loginPage.this, LoginSuccessful.class);
                //Send the email to the setting profile activity to update data from the database
                i.putExtra("emailToChangeProfile", email);
                startActivity(i);
            }else {
                Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });

        forgotPassword.setOnClickListener(view -> startActivity(new Intent(loginPage.this, ForgotPassword.class)));

        registerNewUser.setOnClickListener(view -> startActivity(new Intent(loginPage.this, RegistrationPage.class)));
    }
}