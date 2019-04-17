package com.illinois.lavanyap;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Resource_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respg2);

        ImageButton water_button = findViewById(R.id.water_button);
        ImageButton paper_button = findViewById(R.id.paper_button);
        ImageButton plastic_button = findViewById(R.id.platic_button);
        ImageButton misc_button = findViewById(R.id.misc_button);

        water_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                Resource_Page.this.startActivity(startIntent);


            }
        });
        plastic_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                Resource_Page.this.startActivity(startIntent);


            }
        });
        paper_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                Resource_Page.this.startActivity(startIntent);


            }
        });
        misc_button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Resource_Page.this.getApplicationContext(), List_of_Projects.class);
                Resource_Page.this.startActivity(startIntent);


            }
        });


            //BottomoNavigavtion code
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(Resource_Page.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);
                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(Resource_Page.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_settings:
                        Toast.makeText(Resource_Page.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
        }
}
