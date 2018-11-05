package com.example.ck.minorlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class register3 extends Activity {

    Button sub1,sub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        sub1 = (Button)findViewById(R.id.sub1);
        sub2 = (Button)findViewById(R.id.sub2);

        Intent intent = getIntent();
        final String branch = intent.getStringExtra("branch");
        final String year = intent.getStringExtra("year");

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(register3.this,register4.class);
                myintent.putExtra("branch", branch);
                myintent.putExtra("year", year);
                myintent.putExtra("subject", "DBMS");
                startActivity(myintent);
            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(register3.this,register4.class);
                myintent.putExtra("branch", branch);
                myintent.putExtra("year", year);
                myintent.putExtra("subject", "COMPILER");
                startActivity(myintent);
            }
        });
    }
}
