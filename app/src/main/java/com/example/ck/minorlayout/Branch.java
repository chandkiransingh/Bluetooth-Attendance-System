package com.example.ck.minorlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Branch extends AppCompatActivity {

    Button cs,ec,it;
    TextView emailid,tname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        cs = (Button) findViewById(R.id.sub1);
        ec = (Button) findViewById(R.id.ec);
        it = (Button) findViewById(R.id.it);
        emailid = (TextView) findViewById(R.id.email);
        tname = (TextView) findViewById(R.id.tname);
        Intent intent = getIntent();
        final String email = intent.getStringExtra("email");
        final String teacher = intent.getStringExtra("teacher");
        emailid.setText(""+email.replace("<dot>","."));
        tname.setText(""+teacher);

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
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
