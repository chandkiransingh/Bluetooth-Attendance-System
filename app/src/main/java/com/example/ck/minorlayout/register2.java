package com.example.ck.minorlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.content.ContentValues.TAG;

public class register2 extends AppCompatActivity {

    Button year1,year2,year3,year4,year5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MinorTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        year1 = (Button) findViewById(R.id.sub1);
        year2 = (Button)findViewById(R.id.year2);
        year3 = (Button)findViewById(R.id.year3);
        year4 = (Button)findViewById(R.id.year4);
        year5 = (Button)findViewById(R.id.year5);

        Intent intent = getIntent();

        final String branch = intent.getStringExtra("branch");

        year1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = (new Intent(register2.this,register3.class));
                myintent.putExtra("branch", branch);
                myintent.putExtra("year", "1st year");
                startActivity(myintent);
            }
        });
        year2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =(new Intent(register2.this,register3.class));
                myintent.putExtra("branch", branch);
                myintent.putExtra("year", "2nd year");
                startActivity(myintent);
            }
        });
        year3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =(new Intent(register2.this,register3.class));
                myintent.putExtra("branch", branch);
                myintent.putExtra("year", "3rd year");
                startActivity(myintent);
            }
        });
        year4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =(new Intent(register2.this,register3.class));
                myintent.putExtra("branch", branch);
                myintent.putExtra("year", "4th year");
                startActivity(myintent);
            }
        });
        year5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent =(new Intent(register2.this,register3.class));
                myintent.putExtra("branch", branch);
                myintent.putExtra("year", "5th year");
                startActivity(myintent);
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
