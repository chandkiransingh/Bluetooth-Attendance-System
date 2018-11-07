package com.example.ck.minorlayout;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class attandance1 extends Activity {

    Button cs,ec,it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attandance1);
        cs = (Button) findViewById(R.id.sub1);
        ec = (Button) findViewById(R.id.ec);
        it = (Button) findViewById(R.id.it);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(attandance1.this, attandance2.class);
                myIntent.putExtra("branch", "CS");
                startActivity(myIntent);
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(attandance1.this, attandance2.class);
                myIntent.putExtra("branch", "EC");
                startActivity(myIntent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(attandance1.this, attandance2.class);
                myIntent.putExtra("branch", "IT");
                startActivity(myIntent);
            }
        });
    }
}
