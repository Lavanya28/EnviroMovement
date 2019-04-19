package com.illinois.lavanyap;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class User_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        final SQLiteDatabase mydatabase2 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);

        Button createproject = (Button) findViewById(R.id.createproject);

        //Ecopoints
        TextView ecopoints = (TextView) findViewById(R.id.ecopoints);
        //Total
        TextView total = (TextView) findViewById(R.id.totalsaved);
        //

        // Fetch List of Projects, Eco-points, total  corresponding to user from Profile table

        Bundle b = this.getIntent().getExtras();
        String user = b.getString("username");



        String sel = "Carry reusable bags while grocery shopping";
        // Doesnt work ---> any varchar element
         //Cursor cursor = mydatabase2.rawQuery("SELECT * from UserTable where Password=" + "Pass1" ,null);

        Cursor cursor = mydatabase2.rawQuery("SELECT * from ProfileTable where EcoPoints=" + "18" ,null);
         cursor.moveToFirst();



         String eco = cursor.getString(1);
         ecopoints.setText(eco);






        createproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(User_Profile.this.getApplicationContext(), Projectcreate_page1.class);
                User_Profile.this.startActivity(startIntent);


            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(User_Profile.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);
                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(User_Profile.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_settings:
                        Toast.makeText(User_Profile.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });








    }
}

