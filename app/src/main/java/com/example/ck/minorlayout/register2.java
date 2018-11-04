package com.example.ck.minorlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class register2 extends AppCompatActivity {

    Button year1,year2,year3,year4,year5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        year1 = (Button) findViewById(R.id.sub1);
        year2 = (Button)findViewById(R.id.year2);
        year3 = (Button)findViewById(R.id.year3);
        year4 = (Button)findViewById(R.id.year4);
        year5 = (Button)findViewById(R.id.year5);

        year1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register2.this,attandance3.class));
            }
        });
        year2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register2.this,attandance3.class));
            }
        });
        year3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register2.this,attandance3.class));
            }
        });
        year4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register2.this,attandance3.class));
            }
        });
        year5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register2.this,attandance3.class));
            }
        });

    }
}
