package com.illinois.lavanyap;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.philjay.valuebar.ValueBar;
import com.philjay.valuebar.colors.RedToGreenFormatter;
import java.util.Random;

public class Resource_projectpage extends AppCompatActivity {
    private ValueBar mValueBar;
    private Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle b = this.getIntent().getExtras();
        final String projecttitle = b.getString("project");
        final String user = b.getString("username");
        //fetch title of project

        final TextView title = (TextView) findViewById(R.id.title);

        //Fetch button
        Button joinproject = (Button) findViewById(R.id.joinproject);

        title.setText(projecttitle);

        //fetch all textviews representing numbers of resource saved

        final TextView tot = (TextView) findViewById(R.id.total);

        final TextView metric = (TextView) findViewById(R.id.contribution);
        final TextView motiv = (TextView)findViewById(R.id.contribute);
        final TextView motivation = (TextView) findViewById(R.id.title2);

        final SQLiteDatabase mydatabase4 = openOrCreateDatabase("enviromovement",MODE_PRIVATE,null);
        Cursor cursor = mydatabase4.rawQuery("SELECT * from Project where ProjectName=" +"'"+ projecttitle+"'" ,null);

        cursor.moveToFirst();

        String motivation_text = cursor.getString(3);
        String metric_text = cursor.getString(4);
        String total_text = cursor.getString(6);

        final String pid = cursor.getString(0);

        metric.setText(metric_text);
        motivation.setText(motivation_text);
        motiv.setText(motivation_text);
        tot.setText(total_text);

        joinproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Query2 = "INSERT INTO ProfileTable VALUES (" + "'"+ user + "'" + " ,"+ "'" + pid + "'" +  " , 0 ,0 )" ;
                mydatabase4.execSQL(Query2);


            }
        });

        //Value Bar
        mValueBar=(ValueBar) findViewById(R.id.valueBar);
        mValueBar.setMinMax(0,100);
        mValueBar.setColorFormatter(new RedToGreenFormatter());
        mValueBar.setValue(rand.nextInt(100));

        //Bottom Navagtion
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView6);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(Resource_projectpage.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent startIntent = new Intent(getApplicationContext(), User_Profile.class);

                        startActivity(startIntent);
                        break;
                    case R.id.navigation_resource:
                        Toast.makeText(Resource_projectpage.this, "Resources", Toast.LENGTH_SHORT).show();
                        Intent  resintent = new Intent(getApplicationContext(), Resource_Page.class);
                        startActivity(resintent);
                        break;
                    case R.id.navigation_ecotips:
                        Toast.makeText(Resource_projectpage.this, "EcoTips", Toast.LENGTH_SHORT).show();
                        Intent ecotip = new Intent(getApplicationContext(), Ecotip.class);
                        startActivity(ecotip);
                        break;
                    case R.id.overflow:
                        PopupMenu popup = new PopupMenu(Resource_projectpage.this, findViewById(R.id.overflow));
                        MenuInflater inflater = popup.getMenuInflater();
                        inflater.inflate(R.menu.settings, popup.getMenu());
                        popup.show();

                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                switch (item.getItemId()) {
                                    case R.id.help:
                                        Toast.makeText(Resource_projectpage.this, "Help", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.action_settings:
                                        Toast.makeText(Resource_projectpage.this, "Settings", Toast.LENGTH_SHORT).show();
                                        Intent settingintent = new Intent(getApplicationContext(), SettingsActivity.class);
                                        startActivity(settingintent);
                                        break;
                                    case R.id.info:
                                        Toast.makeText(Resource_projectpage.this, "Info", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.logout:
                                        Intent loginintent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(loginintent);
                                        break;

                                }
                                return true;
                            }
                        });
                }

                return true;
            }
        });




    }
}
