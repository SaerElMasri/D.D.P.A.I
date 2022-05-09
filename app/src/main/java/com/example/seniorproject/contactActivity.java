package com.example.seniorproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class contactActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageButton returnPage;
    Button addContactBtn;

    DatabaseHelper db;
    ArrayList<String> contact_name, contact_phone;
    customAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contact);

        recyclerView = findViewById(R.id.recyclerView);
        returnPage = findViewById(R.id.backButtonContact);
        addContactBtn = findViewById(R.id.addContactBtn);

        db = new DatabaseHelper(this);
        contact_name = new ArrayList<>();
        contact_phone = new ArrayList<>();


        returnPage.setOnClickListener(view -> startActivity(new Intent(contactActivity.this, MainPage.class)));

        addContactBtn.setOnClickListener(view -> startActivity(new Intent(contactActivity.this, addContactPage.class)));

        storeDataInArray();

        customAdapter = new customAdapter(contactActivity.this,this, contact_name, contact_phone);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(contactActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor cursor = db.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(contactActivity.this, "No data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                contact_name.add(cursor.getString(1));
                contact_phone.add(cursor.getString(2));
            }
        }
    }
}