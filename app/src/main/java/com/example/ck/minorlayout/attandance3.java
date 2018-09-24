package com.example.ck.minorlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class attandance3 extends AppCompatActivity {

    Button sub1,sub2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attandance3);
        sub1 = (Button)findViewById(R.id.sub1);
        sub2 = (Button)findViewById(R.id.sub2);

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(attandance3.this,attandance4.class));
            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(attandance3.this,attandance4.class));
            }
        });
    }
}
