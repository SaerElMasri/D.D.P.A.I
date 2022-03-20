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
import android.widget.Toast;

public class addContactPage extends AppCompatActivity {

    ImageButton returnPage;
    EditText contactName;
    EditText contactPhoneNumber;
    Button addContactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_contact_page);

        returnPage = findViewById(R.id.backButtonAddContact);
        contactName = findViewById(R.id.nameContact);
        contactPhoneNumber = findViewById(R.id.phoneContact);
        addContactBtn = findViewById(R.id.addContactBtn);

        //Return to contactPage.java
        returnPage.setOnClickListener(view -> startActivity(new Intent(addContactPage.this, contactPage.class)));

        //Add or edit contacts from the database
        addContactBtn.setOnClickListener(view -> {
            String nameContact = contactName.getText().toString();
            String phoneContact = contactPhoneNumber.getText().toString();
            int phoneNumberContact = Integer.parseInt(phoneContact);

            //Code to add the contact into the database and to be display in the contactPage.java

            //After inserting or editing a phone number display a toast msg
            Toast.makeText(getApplicationContext(), "Contact add/edited successfully", Toast.LENGTH_LONG).show();


        });
    }
}