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
    DatabaseHelper db;

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
        db = new DatabaseHelper(this);


        //Return to contactPage.java
        returnPage.setOnClickListener(view -> startActivity(new Intent(addContactPage.this, contactActivity.class)));

        //Add or edit contacts from the database
        addContactBtn.setOnClickListener(view -> {
            String nameContact = contactName.getText().toString();
            String phoneContact = contactPhoneNumber.getText().toString();

            if(!nameContact.isEmpty() && !phoneContact.isEmpty()){
                Boolean checkContact = db.checkAlreadyExitsContact(phoneContact);
                if(checkContact == true){
                    Toast.makeText(getApplicationContext(), "Contact already saved", Toast.LENGTH_LONG).show();
                }else{
                    Boolean contactAdded = db.InsertContact(nameContact, phoneContact);
                    if(contactAdded == true){
                        Toast.makeText(getApplicationContext(), "Contact saved successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(addContactPage.this, contactActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Error saving the contact", Toast.LENGTH_LONG).show();
                    }
                }
            }else{
                Toast.makeText(getApplicationContext(), "Please fill the required information", Toast.LENGTH_LONG).show();
            }
        });
    }
}