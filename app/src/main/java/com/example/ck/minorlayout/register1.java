package com.example.ck.minorlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class register1 extends Activity {

    Button cs,ec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        cs = (Button) findViewById(R.id.sub1);
        ec= (Button) findViewById(R.id.ec);
        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String branch="cs";
                Intent i = new Intent(register1.this, register4.class);
                i.putExtra("key",branch);
                startActivity(i);
                startActivity(new Intent(register1.this,register2.class));
            }
        });
        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String branch="ec";
                Intent i = new Intent(register1.this, register4.class);
                i.putExtra("key",branch);
                startActivity(i);
                startActivity(new Intent(register1.this,register2.class));
            }
        });
    }
}
