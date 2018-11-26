package com.example.ck.minorlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Teachers extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
   // Button logout;
    TextView textView01,textView02,textView03,textView04,textView05,textView06,textView07,textView08,textView09,textView10,textView11,textView12,textView13,textView14;
    TextView textView15,textView16,textView17,textView18,textView19,textView20,textView21,textView22,textView23,textView24,textView25,textView26,textView27,textView28,textView29;
    TextView textView30,textView31,textView32,textView33,textView34;
    TextView emailid;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        auth = FirebaseAuth.getInstance();
     //   logout = findViewById(R.id.logout);
        emailid = findViewById(R.id.email);
        textView01 = findViewById(R.id.textView01);
        textView02 = findViewById(R.id.textView02);
        textView03 = findViewById(R.id.textView03);
        textView04 = findViewById(R.id.textView04);
        textView05 = findViewById(R.id.textView05);
        textView06 = findViewById(R.id.textView06);
        textView07 = findViewById(R.id.textView07);
        textView08 = findViewById(R.id.textView08);
        textView09 = findViewById(R.id.textView09);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);
        textView16 = findViewById(R.id.textView16);
        textView17 = findViewById(R.id.textView17);
        textView18 = findViewById(R.id.textView18);
        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView30 = findViewById(R.id.textView30);
        textView31 = findViewById(R.id.textView31);
        textView32 = findViewById(R.id.textView32);
        textView33 = findViewById(R.id.textView33);
        textView34 = findViewById(R.id.textView34);

        user = auth.getCurrentUser();
        email = user.getEmail();
        emailid.setText(""+email);
        email = email.replace(".","<dot>");
        email = email.replace("#","<hash>");
        email = email.replace("$","<dollar>");
        email = email.replace("[","<leftsquarebracket>");
        email = email.replace("]","<rightsquarebracket>");

        Log.d("email", "onCreate: email id "+email);

       /* logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                finish();
                Intent i = new Intent(Teachers.this,Login.class);
                startActivity(i);
            }
        });
*/

        textView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Aarti Gautam Dinker");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });

        textView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Abhishek SOICT");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Alpa Yadav");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Ankur Kumar");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "anumpma nandan");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Anurag Singh Baghel");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Aparna Singh");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Arun Solanki");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "deepika Gupta");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Deepshikha Lodhi");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Diksha Sharma");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });

        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Herman Al Ayubi");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Kavita Rani");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Lakhan Singh");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "mamta punia");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "manali");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "namit Bhati");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Navaid Zafar Rizvi");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }
        });
        textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Neeta Singh");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Nidhi Gulati");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Poonam Yadav");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Pradeep Tomar");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Priyanka Goyal");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "R.B Singh");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Rajesh Mishra");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Roshi Saxena");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Sandeep Sharma");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Sandhya Tarar");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Shreya Malhotra");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Sumedha");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Tahseen Fatima");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "vandana malviya");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Vidushi Sharma");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }});
        textView34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Teachers.this, Branch.class);
                myIntent.putExtra("teacher", "Vimlesh Kumar");
                myIntent.putExtra("email", email);
                startActivity(myIntent);
            }

        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }
}
