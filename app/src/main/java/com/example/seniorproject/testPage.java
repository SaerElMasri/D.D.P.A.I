package com.example.seniorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class testPage extends AppCompatActivity {
    ImageButton returnPag;
    ImageView testButton1;
    ImageView testButton2;
    ImageView testButton3;
    TextView dateText1;
    TextView dateText2;
    TextView dateText3;
    TextView percentageText1;
    TextView percentageText2;
    TextView percentageText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_test_page);

        returnPag = findViewById(R.id.backButtonTest);
        dateText1 = findViewById(R.id.date1);
        dateText2 = findViewById(R.id.date2);
        dateText3 = findViewById(R.id.date3);
        percentageText1 = findViewById(R.id.percentage1);
        percentageText2 = findViewById(R.id.percentage2);
        percentageText3 = findViewById(R.id.percentage3);


        //Last 4 test taken will be shown in this page

        //First Box
        //Date and percentage of alcohol
        //String dateTest1 = value taken from the database
        //Double percentage1 = 0.0;
        //dateText1.setText(dateTest1);
        //percentageText1.setText(percentage1);

        //Second Box
        //Date and percentage of alcohol
        //String dateTest2 = value taken from the database
        //Double percentage2 = 0.0;
        //dateText2.setText(dateTest2);
        //percentageText2.setText(percentage2);

        //Third Box
        //Date and percentage of alcohol
        //String dateTest3 = value taken from the database
        //Double percentage3 = 0.0;
        //dateText3.setText(dateTest3);
        //percentageText3.setText(percentage3);

        returnPag.setOnClickListener(view -> startActivity(new Intent(testPage.this, MainPage.class)));

    }
}