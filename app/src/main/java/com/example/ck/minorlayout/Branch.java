package com.example.ck.minorlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Branch extends AppCompatActivity {

    Button cs,ec,it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        cs = (Button) findViewById(R.id.sub1);
        ec = (Button) findViewById(R.id.ec);
        it = (Button) findViewById(R.id.it);

        Intent intent = getIntent();
        final String email = intent.getStringExtra("email");
        final String teacher = intent.getStringExtra("teacher");

        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Branch.this, Subjects.class);
                myIntent.putExtra("branch", "CS");
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                startActivity(myIntent);
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Branch.this, Subjects.class);
                myIntent.putExtra("branch", "EC");
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                startActivity(myIntent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Branch.this, Subjects.class);
                myIntent.putExtra("branch", "IT");
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                startActivity(myIntent);
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
