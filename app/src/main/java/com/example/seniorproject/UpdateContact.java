package com.example.seniorproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class UpdateContact extends AppCompatActivity {
    ImageView returnBtn;
    EditText contactName, oldPhone, updatedPhone;
    Button updateContact, deleteContact;
    DatabaseHelper db;

    String contactNameIntent, contactPhoneIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_update_contact);

        returnBtn = findViewById(R.id.backButtonUpdContact);
        contactName = findViewById(R.id.nameContactUpdate);
        oldPhone = findViewById(R.id.phoneContactUpdate);
        updatedPhone = findViewById(R.id.newPhoneContactUpdate);
        updateContact = findViewById(R.id.updateBtn);
        deleteContact = findViewById(R.id.deleteBtn);
        db = new DatabaseHelper(this);

        updateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPhone = updatedPhone.getText().toString().trim();
                Boolean updateDone = db.updateContact(contactPhoneIntent, contactNameIntent, newPhone);
                if(updateDone == true){
                    Toast.makeText(UpdateContact.this, "Update Successfully Done!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateContact.this, contactActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(UpdateContact.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
        getIntentData();
    }

    void getIntentData(){
        if(getIntent().hasExtra("contactName") && getIntent().hasExtra("contactPhone")){
            contactNameIntent = getIntent().getStringExtra("contactName");
            contactPhoneIntent = getIntent().getStringExtra("contactPhone");

            contactName.setText(contactNameIntent);
            oldPhone.setText(contactPhoneIntent);
        }else{
            Toast.makeText(this, "Not data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete user: " + contactNameIntent + "?");
        builder.setMessage("Are you sure you want to delete " + contactNameIntent + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Boolean contactDeleted = db.deleteOneContact(contactPhoneIntent);
                if(contactDeleted == true){
                    Toast.makeText(UpdateContact.this, "Contact successfully deleted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateContact.this, contactActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(UpdateContact.this, "Error to delete contact", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}