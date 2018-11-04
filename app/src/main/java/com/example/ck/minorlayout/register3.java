package com.example.ck.minorlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class register3 extends AppCompatActivity {

    Button sub1,sub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        sub1 = (Button)findViewById(R.id.sub1);
        sub2 = (Button)findViewById(R.id.sub2);

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register3.this,attandance4.class));
            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register3.this,attandance4.class));
            }
        });
    }
}
