package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    EditText fullName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    CheckBox policyBox;
    Button button;
    TextView haveAccount;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration_page);

        fullName = findViewById(R.id.registrationFullName);
        email = findViewById(R.id.registrationEmail);
        password = findViewById(R.id.registrationPassword);
        confirmPassword = findViewById(R.id.registrationConfirmPassword);
        policyBox = findViewById(R.id.registrationCheckBox);
        button = findViewById(R.id.registrationBtn);
        haveAccount = findViewById(R.id.loginRegistration);
        databaseHelper = new DatabaseHelper(this);

        //Change the data type from the text boxes
        fullName.setInputType(InputType.TYPE_CLASS_TEXT);
        email.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        confirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        //Registration back-end process
        button.setOnClickListener(view -> {
            String fullNameUser = fullName.getText().toString();
            String emailUser = email.getText().toString();
            String passUser = password.getText().toString();
            String confirmPass = confirmPassword.getText().toString();


            if(!fullNameUser.isEmpty() && !emailUser.isEmpty() && !passUser.isEmpty() && !confirmPass.isEmpty()){
                if(passUser.equals(confirmPass)){
                    Boolean checkEmail = databaseHelper.CheckEmail(emailUser);
                    if(checkEmail == true){
                        Intent intent = new Intent(RegistrationPage.this, ImpairedRegistration.class);

                        //Send all user's data to save them after taking the phone number
                        intent.putExtra("username", fullNameUser);
                        intent.putExtra("emailUser",emailUser);
                        intent.putExtra("userPass", passUser);
                        startActivity(intent);

                        fullName.setText("");
                        email.setText("");
                        password.setText("");
                        confirmPassword.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(), "Email already registered", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast errorToast = Toast.makeText(RegistrationPage.this, "Passwords do not match", Toast.LENGTH_SHORT);
                    errorToast.show();
                }
            }else if(fullNameUser.isEmpty() || emailUser.isEmpty() || passUser.isEmpty() || confirmPass.isEmpty()){
                Toast errorToast = Toast.makeText(RegistrationPage.this, "Please fill the required information", Toast.LENGTH_SHORT);
                errorToast.show();
            }else{
                Toast errorToast = Toast.makeText(RegistrationPage.this, "Error", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });


        //Jump to the login page
        haveAccount.setOnClickListener(view -> startActivity(new Intent(RegistrationPage.this, loginPage.class)));
    }
}