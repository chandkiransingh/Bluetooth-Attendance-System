package com.example.ck.minorlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Subjects extends AppCompatActivity {

    String subjects;
    TextView textView6,textView7,textView8,textView9,textView35,textView36,textView37,textView38;
    TextView emailid,tname,branches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
            Intent intent = getIntent();
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView35 = findViewById(R.id.textView35);
        textView36 = findViewById(R.id.textView36);
        textView37 = findViewById(R.id.textView37);
        textView38 = findViewById(R.id.textView38);
        emailid = findViewById(R.id.email);
        tname = findViewById(R.id.tname);
        branches = findViewById(R.id.branch);


        final String email = intent.getStringExtra("email");
        final String teacher = intent.getStringExtra("teacher");
        final String branch = intent.getStringExtra("branch");
        Log.d("teacher value", "onCreate: teacher value"+teacher);

        emailid.setText(""+email.replace("<dot>","."));
        tname.setText(""+teacher);
        branches.setText(""+branch);

        if(teacher.equals("Aarti Gautam Dinker"))
        {
            textView6.setText("CS381 Web Development Lab");
            textView7.setText("CS695 Computer Security");
            textView8.setText("EC631 Security in Wireless Networks");
        }
        else if(teacher.equals("Abhishek SOICT"))
        {
            textView6.setText("CS283 Data Structure and Algorithms Lab");
            textView7.setText("CS205 Data Structure and Algorithms");
            textView8.setText("IT207 Data Structures");

        }
        else if(teacher.equals("Ankur Kumar"))
        {
            textView6.setText("CS281 Internet Technology Lab");
            textView7.setText("CS305 Computer Graphics");
            textView8.setText("IT281 Animation and Computer Graphics Lab");
            textView9.setText("IT203 Animation and Computer Graphics");
        }
        else if(teacher.equals("anumpma nandan"))
        {
            textView6.setText("EC281 Digital Electronics Lab");
            textView7.setText("EC207 Electronic Devices and Circuits");
            textView8.setText("EC283 Electronic Circuits Lab");
            textView9.setText("EC405 Wireless Mobile Communication");
        }
        else if(teacher.equals("Anurag Singh Baghel"))
        {
            textView6.setText("CS205 Data Structure and Algorithms");
            textView7.setText("CS283 Data Structure and Algorithms Lab");

        }
        else if(teacher.equals("Aparna Singh"))
        {
            textView6.setText("CS203 Operating Systems");
            textView7.setText("CS283 Data Structure and Algorithms Lab");
            textView8.setText("CS309 Computer Organization and Architecture");

        }
        else if(teacher.equals("Arun Solanki"))
        {
            textView6.setText("CS521 Advanced database management");
            textView7.setText("CS581 Adavnced database management system");
            textView8.setText("CS661 Expert System Design");
            textView9.setText("CS683 Expert System Design Lab");
        }
        else if(teacher.equals("deepika Gupta"))
        {
            textView6.setText("IT307 Computer Programming III");
            textView7.setText("IT387 Computer Programming III Lab");
            textView8.setText("IT303 Computer Networks");

        }
        else if(teacher.equals("Deepshikha Lodhi"))
        {
            textView6.setText("EC281 Digital Electronics Lab");
            textView7.setText("EC401 Optical Communication");

        }
        else if(teacher.equals("Diksha Sharma"))
        {
            textView6.setText("CS481 Compiler Design Lab");

        }
        else if(teacher.equals("Herman Al Ayubi"))
        {
            textView6.setText("EC385 Antenna and Wave propagation Lab");
            textView7.setText("EC403 Principle of VLSI Design	HAA");
            textView8.setText("EC683 Design Lab II");
            textView9.setText("EC675 Mixed signal VLSI design");
        }
        else if(teacher.equals("Kavita Rani"))
        {
            textView6.setText("IT209 System Design and Analysis Techniques");
            textView7.setText("CS641 Aspect Oriented Software Engineering");

        }
        else if(teacher.equals("Lakhan Singh"))
        {
            textView6.setText("CS383 Computer Graphics Lab");
            textView7.setText("CS523 Advance Computer Architecture");
        }
        else if(teacher.equals("mamta punia"))
        {
            textView6.setText("CS201 Internet Technology");
            textView7.setText("CS281 Internet Technology Lab");
            textView8.setText("CS669 Fuzzy Set Theory");

        }
        else if(teacher.equals("manali"))
                        {
            textView6.setText("CS309 Computer Organization and Architecture");
            textView7.setText("CS481 Compiler Design Lab");
            textView8.setText("CS673 Computer Networks and Distributed Systems");
            textView9.setText("CS685 Computer Network and Distributed Systems Lab");
            textView35.setText("IT285 Data Structures Lab");
        }
        else if(teacher.equals("namit Bhati"))
        {
            textView6.setText("CS699 Robotics");
            textView7.setText("IT287 Web Technologies Lab 1");
            textView8.setText("IT311 Industrial Economics and Managemen");

        }
        else if(teacher.equals("Navaid Zafar Rizvi"))
        {
            textView6.setText("EC385 Antenna and Wave propagation Lab");
            textView7.setText("EC305 Antenna and Wave Propagatio");
            textView8.setText("EC683 Design Lab II");
            textView9.setText("EC667 RF MEMS design and technology");
        }
        else if(teacher.equals("Neeta Singh"))
        {
            textView6.setText("CS451 Wireless Technologies");
            textView7.setText("IT383 Computer Networks lab");
            textView8.setText("EC635 Mobile Computing");
            textView9.setText("EC681 Design Lab-II");
        }
        else if(teacher.equals("Nidhi Gulati"))
        {
            textView6.setText("CS207 System Analysis and Design");
            textView7.setText("CS201 Internet Technology");
            textView8.setText("CS281 Internet Technology Lab");

        }
        else if(teacher.equals("Poonam Yadav"))
        {
            textView6.setText("CS303 Web Development");
            textView7.setText("CS405 Formal Methods");
            textView8.setText("CS675 Multimedia and computer graphics");

        }
        else if(teacher.equals("Pradeep Tomar"))
        {
            textView6.setText("IT205 Operating Systems");
            textView7.setText("IT283 Operating Systems Lab");
            textView8.setText("CS633 Component based software engg");

        }
        else if(teacher.equals("Priyanka Goyal"))
        {
            textView6.setText("EC301 Digital Logic Design");
            textView7.setText("EC381 Logic Design Lab");
            textView8.setText("EC633 Low power VLSI design");
        }
        else if(teacher.equals("R.B Singh"))
        {
            textView6.setText("EC201 Digital Electronics");
            textView7.setText("EC281 Digital Electronics Lab");

        }
        else if(teacher.equals("Rajesh Mishra"))
        {
            textView6.setText("EC443 Telecommunication switching and Networks");
            textView7.setText("EC481 Optical Communication Lab");
            textView8.setText("EC673 VLSI reliability engg");
            textView9.setText("EC641 Netowrk Reliability");
        }
        else if(teacher.equals("Roshi Saxena"))
        {
            textView6.setText("CS301 Theory of Automata");
            textView7.setText("CS403 Object-Oriented Analysis");
            textView8.setText("IT30 Theory of Automata");
            textView9.setText("IT389 Web Technologies LabIII");
        }
        else if(teacher.equals("Sandeep Sharma"))
        {
            textView6.setText("EC303 Digital Communication Systems");
            textView7.setText("EC383 Digital Communication Lab");

        }
        else if(teacher.equals("Sandhya Tarar"))
        {
            textView6.setText("CS401 Compiler Design	ST	Sandhya Tarar");
            textView7.setText("IT305 Compiler Design");
            textView8.setText("IT385 Compiler Design Lab");

        }
        else if(teacher.equals("Shreya Malhotra"))
        {
            textView6.setText("CS311 e-Commerce");
            textView7.setText("IT389 Web Technologies LabIII");
            textView8.setText("CS645 Software Quality Assurance");

        }
        else if(teacher.equals("Sumedha"))
        {
            textView6.setText("CS307 Analysis and Design of Algorithms");
            textView7.setText("EC635 Mobile Computing");
            textView8.setText("CS631 Software Testing");
            textView9.setText("CS681 Software Testing Lab");
        }
        else if(teacher.equals("Tahseen Fatima"))
        {
            textView6.setText("EC281 Digital Electronics Lab");
            textView7.setText("EC203 Network Analysis and Synthesis");
            textView8.setText("EC381 Logic Design Lab");
            textView9.setText("EC441 Design with microcontrollers");
        }
        else if(teacher.equals("vandana malviya"))
        {
            textView6.setText("CS207 System Analysis and Design");
            textView7.setText("CS663 Intelligent Information Retrieval");

        }
        else if(teacher.equals("Vidushi Sharma"))
        {
            textView6.setText("CS527 Research Techniques");
            textView7.setText("CS585 Intelligent system design lab");
            textView8.setText("EC647 Sensor Networks");
            textView9.setText("CS527 Research Techniques");
            textView35.setText("CS751 Next Generation Networks");

        }
        else if(teacher.equals("Vimlesh Kumar"))
        {
            textView6.setText("EC205 Signal and Systems");
            textView7.setText("EC281 Digital Electronics Lab");
            textView8.setText("EC307 Introduction to Control Theory");
            textView9.setText("EC481 Optical Communication Lab");
        }

        else
        {
            Log.d(" unknown teacher", "unknown teacher "+teacher);
        }

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView6.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView7.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView8.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView9.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        textView35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView35.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        textView36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView36.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        textView37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView37.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        textView38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects =textView38.getText().toString();
                Intent myIntent = new Intent(Subjects.this, MainActivity.class);
                myIntent.putExtra("email", email);
                myIntent.putExtra("teacher", teacher);
                myIntent.putExtra("branch", branch);
                myIntent.putExtra("subjects", subjects);
                startActivity(myIntent);
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
